package enigma.travelwise.service.impl;

import enigma.travelwise.model.*;
import enigma.travelwise.repository.OrderAccommodationRepository;
import enigma.travelwise.service.AccommodationService;
import enigma.travelwise.service.OrderAccommodationDetailService;
import enigma.travelwise.service.OrderAccommodationService;
import enigma.travelwise.service.UserService;
import enigma.travelwise.utils.dto.CreateTransactionResponse;
import enigma.travelwise.utils.dto.OrderAccommodationDTO;
import enigma.travelwise.utils.dto.OrderAccommodationDetailDTO;
import enigma.travelwise.utils.dto.Transaction;
import enigma.travelwise.utils.specification.OrderAccommodationSpecification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderAccommodationServiceImpl implements OrderAccommodationService {
    private final OrderAccommodationRepository orderAccommodationRepository;
    private final OrderAccommodationDetailService orderAccommodationDetailService;
    private final UserService userService;
    private final AccommodationService accommodationService;


    @Override
    @Transactional
    public OrderAccommodation create(OrderAccommodationDTO request) {
        UserEntity user = userService.getById(request.getUserId());
        List<OrderAccommodationDetailDTO> details = request.getOrderAccommodationDetails();
        OrderAccommodation newOrderAccommodation = new OrderAccommodation();
        newOrderAccommodation.setUser(user);
        newOrderAccommodation.setCheckIn(request.getCheckIn());
        newOrderAccommodation.setCheckOut(request.getCheckOut());

        OrderAccommodation result = orderAccommodationRepository.save(newOrderAccommodation);
        int pricePlaceHolder = 0;
        int total_qty = 0;
        List<OrderAccommodationDetail> oad_list = new ArrayList<>();
        for (OrderAccommodationDetailDTO detail : details) {
            Accommodation acc = accommodationService.getById(detail.getAccommodationId());
            String price_tag = detail.getCategory().toLowerCase();
            Integer cat_price = acc.getCategory_prices().get(price_tag);

            int qty = detail.getQuantity();
            total_qty += qty;
            cat_price *= qty;

            detail.setOrderAccommodation(result);
            pricePlaceHolder += cat_price;
            OrderAccommodationDetail oad = orderAccommodationDetailService.create(detail);
            oad_list.add(oad);
        }
        if (request.getCheckIn().isAfter(request.getCheckOut())) {
            throw new IllegalArgumentException("Check-in date must be before the checkout date.");
        }


        log.warn(Integer.toString(pricePlaceHolder));

        LocalDate checkIn = request.getCheckIn();
        LocalDate checkout = request.getCheckOut();

        long dayStay = ChronoUnit.DAYS.between(checkIn, checkout);
        int totalday = (int) dayStay;
        pricePlaceHolder = totalday * pricePlaceHolder;

        result.setTotalPrice(pricePlaceHolder);
        result.setAccommodationDetails(oad_list);
        result.setStatus(PaymentStatus.PROCESSING);
        orderAccommodationRepository.save(result);



        return result;
    }

    @Override
    public Page<OrderAccommodation> getAll(Pageable pageable, Long userId, Integer totalPrice, LocalDate checkIn, LocalDate checkOut) {
        Specification<OrderAccommodation> specification = OrderAccommodationSpecification.getSpecification(userId, totalPrice, checkIn, checkOut);
        return orderAccommodationRepository.findAll(specification, pageable);
    }

    @Override
    public OrderAccommodation getOne(Long id) {
        return orderAccommodationRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public boolean updatePaymentStatus(Long id, String status) {
        OrderAccommodation orderAccommodation = getOne(id);
        orderAccommodation.setStatus(PaymentStatus.COMPLETED);
        orderAccommodationRepository.save(orderAccommodation);
        return true;
    }
}
