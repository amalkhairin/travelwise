package enigma.travelwise.service;

import enigma.travelwise.model.OrderAccommodationDetail;
import enigma.travelwise.utils.dto.OrderAccommodationDetailDTO;

import java.util.List;

public interface OrderAccommodationDetailService {
    OrderAccommodationDetail create(OrderAccommodationDetailDTO request);
    List<OrderAccommodationDetail> getAll();
    OrderAccommodationDetail getOne(Long id);

}
