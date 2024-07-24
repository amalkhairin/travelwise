package enigma.travelwise.service.impl;

import enigma.travelwise.model.OrderAccommodation;
import enigma.travelwise.model.UserEntity;
import enigma.travelwise.repository.OrderAccommodationRepository;
import enigma.travelwise.service.OrderAccommodationDetailService;
import enigma.travelwise.service.OrderAccommodationService;
import enigma.travelwise.service.UserService;
import enigma.travelwise.utils.dto.OrderAccommodationDTO;
import enigma.travelwise.utils.dto.OrderAccommodationDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderAccommodationServiceImpl implements OrderAccommodationService {
    @Autowired
    private final OrderAccommodationRepository orderAccommodationRepository;
    @Autowired
    private final OrderAccommodationDetailService orderAccommodationDetailService;
    @Autowired
    private final UserService userService;

    @Override
    public OrderAccommodation create(OrderAccommodationDTO request) {
        UserEntity user = userService.getById(request.getUserId());
        List<OrderAccommodationDetailDTO> details = request.getOrderAccommodationDetails();
        OrderAccommodation newOrderAccommodation = new OrderAccommodation();
        newOrderAccommodation.setUser(user);
        newOrderAccommodation.setCheckIn(request.getCheckIn());
        newOrderAccommodation.setCheckOut(request.getCheckOut());

        OrderAccommodation result = orderAccommodationRepository.save(newOrderAccommodation);
//        Integer pricePlaceHolder = 0;
        for (OrderAccommodationDetailDTO detail : details) {
            detail.setOrderAccommodation(result);
//            pricePlaceHolder += detail.getPrice();
            orderAccommodationDetailService.create(detail);
        }
        if (request.getCheckIn().isAfter(request.getCheckOut())) {
            throw new IllegalArgumentException("Check-in date must be before the checkout date.");
        }

//        LocalDate checkIn = request.getCheckIn();
//        LocalDate checkout = request.getCheckOut();

//        long dayStay = ChronoUnit.DAYS.between(checkIn, checkout);
//        pricePlaceHolder *= (int) dayStay;

//        result.setTotalPrice(pricePlaceHolder);
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
