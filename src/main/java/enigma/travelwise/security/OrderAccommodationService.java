package enigma.travelwise.security;

import enigma.travelwise.model.OrderAccommodation;
import enigma.travelwise.utils.dto.OrderAccommodationDTO;

import java.util.List;

public interface OrderAccommodationService {
    OrderAccommodation create(OrderAccommodationDTO request);
    List<OrderAccommodation> getAll();
    OrderAccommodation getOne(Long id);
}
