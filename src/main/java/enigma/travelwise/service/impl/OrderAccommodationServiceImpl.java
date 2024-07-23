package enigma.travelwise.service.impl;

import enigma.travelwise.model.OrderAccommodation;
import enigma.travelwise.model.UserEntity;
import enigma.travelwise.repository.OrderAccommodationRepository;
import enigma.travelwise.service.OrderAccommodationDetailService;
import enigma.travelwise.service.OrderAccommodationService;
import enigma.travelwise.utils.dto.OrderAccommodationDTO;
import enigma.travelwise.utils.dto.OrderAccommodationDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderAccommodationServiceImpl implements OrderAccommodationService {
    private final OrderAccommodationRepository orderAccommodationRepository;
    private final OrderAccommodationDetailService orderAccommodationDetailService;

    @Override
    public OrderAccommodation create(OrderAccommodationDTO request) {
//        UserEntity user = userService.getOne(request.getUserId());
        List<OrderAccommodationDetailDTO> details = request.getOrderAccommodationDetails();
        OrderAccommodation newOrderAccommodation = new OrderAccommodation();
//        newOrderAccommodation.setUser(user);

        OrderAccommodation result = orderAccommodationRepository.save(newOrderAccommodation);

        for (OrderAccommodationDetailDTO detail : details) {
            detail.setOrderAccommodation(result);
            orderAccommodationDetailService.create(detail);
        }

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
