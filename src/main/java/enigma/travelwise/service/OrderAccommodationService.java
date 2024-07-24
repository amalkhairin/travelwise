package enigma.travelwise.service;

import enigma.travelwise.model.OrderAccommodation;
import enigma.travelwise.utils.dto.OrderAccommodationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderAccommodationService {
    OrderAccommodation create(OrderAccommodationDTO request);
    List<OrderAccommodation> getAll();
    OrderAccommodation getOne(Long id);
}
