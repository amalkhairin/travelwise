package enigma.travelwise.service;

import enigma.travelwise.model.OrderAccommodation;
import enigma.travelwise.utils.dto.OrderAccommodationDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface OrderAccommodationService {
    OrderAccommodation create(OrderAccommodationDTO request);

    List<OrderAccommodation> getAll(Long userId, Integer totalPrice, LocalDate checkIn, LocalDate checkOut);

    OrderAccommodation getOne(Long id);

    boolean updatePaymentStatus(Long id, String status);
}
