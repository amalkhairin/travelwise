package enigma.travelwise.service;

import enigma.travelwise.model.OrderAccommodationDetail;
import enigma.travelwise.utils.dto.OrderAccommodationDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderAccommodationDetailService {
    OrderAccommodationDetail create(OrderAccommodationDetailDTO request);
    List<OrderAccommodationDetail> getAll(Integer price, Integer quantity, String categoryRoom, Long accommodationId);
    OrderAccommodationDetail getOne(Long id);

}
