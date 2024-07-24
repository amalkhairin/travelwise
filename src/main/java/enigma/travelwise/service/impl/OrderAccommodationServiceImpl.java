package enigma.travelwise.service.impl;

import enigma.travelwise.model.Accommodation;
import enigma.travelwise.model.OrderAccommodation;
import enigma.travelwise.model.OrderAccommodationDetail;
import enigma.travelwise.model.UserEntity;
import enigma.travelwise.repository.OrderAccommodationRepository;
import enigma.travelwise.service.AccommodationService;
import enigma.travelwise.service.OrderAccommodationDetailService;
import enigma.travelwise.service.OrderAccommodationService;
import enigma.travelwise.service.UserService;
import enigma.travelwise.utils.dto.OrderAccommodationDTO;
import enigma.travelwise.utils.dto.OrderAccommodationDetailDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderAccommodationServiceImpl implements OrderAccommodationService {
    @Autowired
    private final OrderAccommodationRepository orderAccommodationRepository;
    @Autowired
    private final OrderAccommodationDetailService orderAccommodationDetailService;
    @Autowired
    private final UserService userService;
    private final AccommodationService accommodationService;

    @Override
    public OrderAccommodation create(OrderAccommodationDTO request) {
        UserEntity user = userService.getById(request.getUserId());
        List<OrderAccommodationDetailDTO> details = request.getOrderAccommodationDetails();
        OrderAccommodation newOrderAccommodation = new OrderAccommodation();
        newOrderAccommodation.setUser(user);
        newOrderAccommodation.setCheckIn(request.getCheckIn());
        newOrderAccommodation.setCheckOut(request.getCheckOut());

        OrderAccommodation result = orderAccommodationRepository.save(newOrderAccommodation);
        Integer pricePlaceHolder = 0;
        List<OrderAccommodationDetail> oad_list = new ArrayList<>();
        for (OrderAccommodationDetailDTO detail : details) {
            Accommodation acc = accommodationService.getById(detail.getAccommodationId());
            String price_tag = detail.getCategory().toLowerCase();
            Integer cat_price = acc.getCategory_prices().get(price_tag);

            int qty = detail.getQuantity();
            cat_price *= qty;

            log.warn("");
            log.warn("------");
            log.warn(cat_price.toString());
            log.warn("");

            detail.setOrderAccommodation(result);
            pricePlaceHolder += cat_price;
            OrderAccommodationDetail oad = orderAccommodationDetailService.create(detail);
            oad_list.add(oad);
        }
        if (request.getCheckIn().isAfter(request.getCheckOut())) {
            throw new IllegalArgumentException("Check-in date must be before the checkout date.");
        }


        log.warn(pricePlaceHolder.toString());

        LocalDate checkIn = request.getCheckIn();
        LocalDate checkout = request.getCheckOut();

        long dayStay = ChronoUnit.DAYS.between(checkIn, checkout);
        int totalday = (int) dayStay;
        pricePlaceHolder = totalday * pricePlaceHolder;

        result.setTotalPrice(pricePlaceHolder);
        result.setAccommodationDetails(oad_list);
        orderAccommodationRepository.save(result);

        return result;
    }

    @Override
    public List<OrderAccommodation> getAll() {
        return orderAccommodationRepository.findAll();
    }

    @Override
    public OrderAccommodation getOne(Long id) {
        return orderAccommodationRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
