package enigma.travelwise.service.impl;

import enigma.travelwise.model.OrderDetailDestination;
import enigma.travelwise.repository.OrderDetailDestinationRepository;
import enigma.travelwise.service.OrderDestinationService;
import enigma.travelwise.service.OrderDetailDestinationService;
import enigma.travelwise.service.UserService;
import enigma.travelwise.utils.dto.OrderDetailDestinationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailDestinationImpl implements OrderDetailDestinationService {
    private final OrderDetailDestinationRepository orderDetailDestinationRepository;
    private final OrderDestinationService orderDestinationService;


    @Override
    public OrderDetailDestination create(OrderDetailDestinationDTO orderDetailDestinationDTO) {
        OrderDetailDestination orderDetailDestination = OrderDetailDestination.builder()
                .orderDestinationId(orderDestinationService.getById(orderDetailDestinationDTO.getOrderDestinationId()))
                //destinationservice
                .price(orderDetailDestinationDTO.getPrice())
                .quantity(orderDetailDestinationDTO.getQuantity())
                .categoryTicket(orderDetailDestinationDTO.getCategoryTicket())
                .build();

        orderDetailDestinationRepository.save(orderDetailDestination);
        return orderDetailDestination;
    }

    @Override
    public OrderDetailDestination getById(Long id) {
        return orderDetailDestinationRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException()
        );
    }

    @Override
    public List<OrderDetailDestination> getall() {
        return orderDetailDestinationRepository.findAll();
    }
}
