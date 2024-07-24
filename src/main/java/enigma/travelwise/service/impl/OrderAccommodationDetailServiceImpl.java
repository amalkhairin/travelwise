package enigma.travelwise.service.impl;

import enigma.travelwise.model.OrderAccommodation;
import enigma.travelwise.model.OrderAccommodationDetail;
import enigma.travelwise.service.OrderAccommodationDetailService;
import enigma.travelwise.service.OrderAccommodationService;
import enigma.travelwise.utils.dto.OrderAccommodationDTO;
import enigma.travelwise.utils.dto.OrderAccommodationDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAccommodationDetailServiceImpl implements OrderAccommodationDetailService {

    @Override
    public OrderAccommodationDetail create(OrderAccommodationDetailDTO request) {
        return null;
    }

    @Override
    public List<OrderAccommodationDetail> getAll() {
        return List.of();
    }

    @Override
    public OrderAccommodationDetail getOne(Long id) {
        return null;
    }
}
