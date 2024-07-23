package enigma.travelwise.service.impl;

import enigma.travelwise.model.OrderDestination;
import enigma.travelwise.repository.OrderDestinationRepository;
import enigma.travelwise.service.OrderDestinationService;
import enigma.travelwise.service.UserService;
import enigma.travelwise.utils.dto.OrderDestinationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDestinationImpl implements OrderDestinationService {
    private final OrderDestinationRepository orderDestinationRepository;
    private final UserService userService;

    @Override
    public OrderDestination create(OrderDestinationDTO orderDestinationDTO) {
        OrderDestination orderDestination = OrderDestination.builder()
                .userId(userService.getById(orderDestinationDTO.getUserId()))
                .totalPrice(orderDestinationDTO.getTotalPrice())
                .orderDate(orderDestinationDTO.getOrderDate())
                .status(orderDestinationDTO.getStatus())
                .build();
        orderDestinationRepository.save(orderDestination);
        return orderDestination;
    }

    @Override
    public OrderDestination getById(Long id) {
        return orderDestinationRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException()
        );
    }

    @Override
    public List<OrderDestination> getall() {
        return orderDestinationRepository.findAll();
    }
}
