package enigma.travelwise.service;

import enigma.travelwise.model.OrderAccommodation;
import enigma.travelwise.model.PaymentStatus;
import enigma.travelwise.utils.dto.OrderAccommodationDTO;

import java.time.LocalDate;
import java.util.List;

public interface OrderAccommodationService {
    OrderAccommodation create(OrderAccommodationDTO request);

    List<OrderAccommodation> getAll(Long userId, Integer totalPrice, LocalDate checkIn, LocalDate checkOut);

    OrderAccommodation getOne(String id);

    void updatePaymentStatus(String id, PaymentStatus status);


}
