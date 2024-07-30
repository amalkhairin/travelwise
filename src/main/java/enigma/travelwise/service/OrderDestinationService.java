package enigma.travelwise.service;

import enigma.travelwise.model.OrderDestination;
import enigma.travelwise.model.PaymentStatus;
import enigma.travelwise.utils.dto.OrderDestinationDTO;

import java.time.LocalDate;
import java.util.List;

public interface OrderDestinationService {
    OrderDestination create(OrderDestinationDTO request);

    List<OrderDestination> getAll(Long userId, Integer totalPrice, LocalDate orderDate);

    OrderDestination getOne(String id);
    void updatePaymentStatus(String id, PaymentStatus status);
}
