package enigma.travelwise.service;

import enigma.travelwise.model.OrderAccommodationDetail;
import enigma.travelwise.utils.dto.OrderAccommodationDetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderAccommodationDetailService {
    OrderAccommodationDetail create(OrderAccommodationDetailDTO request);
    Page<OrderAccommodationDetail> getAll(Pageable pageable);
    OrderAccommodationDetail getOne(Long id);

}
