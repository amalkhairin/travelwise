package enigma.travelwise.service.impl;

import enigma.travelwise.model.Destination;
import enigma.travelwise.model.OrderDestination;
import enigma.travelwise.model.OrderDestinationDetail;
import enigma.travelwise.model.UserEntity;
import enigma.travelwise.repository.OrderDestinationRepository;
import enigma.travelwise.service.*;
import enigma.travelwise.utils.dto.OrderDestinationDTO;
import enigma.travelwise.utils.dto.OrderDestinationDetailDTO;
import enigma.travelwise.utils.specification.OrderDestinationSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDestinationServiceImpl implements OrderDestinationService {
    private final OrderDestinationRepository orderDestinationRepository;
    private final OrderDestinationDetailService orderDestinationdetailService;
    private final UserService userService;
    private final DestinationService destinationService;

    @Override
    public OrderDestination create(OrderDestinationDTO request) {
        UserEntity user = userService.getById(request.getUserId());
        List<OrderDestinationDetailDTO> details = request.getOrderDestinationDetails();
        OrderDestination newOrderDestination = new OrderDestination();
        newOrderDestination.setUser(user);
        newOrderDestination.setOrderDate(request.getOrderDate());

        OrderDestination result = orderDestinationRepository.save(newOrderDestination);
        int pricePlaceHolder = 0;
        List<OrderDestinationDetail> odd_list = new ArrayList<>();
        for (OrderDestinationDetailDTO detail : details) {
            Destination des = destinationService.getById(detail.getDestinationId());
            String price_tag = detail.getCategory().toLowerCase();
            Integer cat_price = des.getCategoryPrices().get(price_tag);

            int qty = detail.getQuantity();
            cat_price *= qty;

            detail.setOrderDestination(result);
            pricePlaceHolder += cat_price;
            OrderDestinationDetail odd = orderDestinationdetailService.create(detail);
            odd_list.add(odd);
        }

        result.setTotalPrice(pricePlaceHolder);
        result.setDestinationDetails(odd_list);
        return orderDestinationRepository.save(result);
    }

    @Override
    public List<OrderDestination> getAll(Long userId, Integer totalPrice, LocalDate orderDate) {
        Specification<OrderDestination> specification = OrderDestinationSpecification.getSpecification(userId, totalPrice, orderDate);
        return orderDestinationRepository.findAll(specification);
    }

    @Override
    public OrderDestination getOne(Long id) {
        return orderDestinationRepository.findById(id).orElseThrow(() -> new RuntimeException("Order Destination not found"));
    }
}
