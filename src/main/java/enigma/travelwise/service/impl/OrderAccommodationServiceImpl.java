package enigma.travelwise.service.impl;

import enigma.travelwise.model.OrderAccommodationDetail;
import enigma.travelwise.service.OrderAccommodationDetailService;
import enigma.travelwise.utils.dto.OrderAccommodationDetailDTO;

import java.util.List;

public class OrderAccommodationServiceImpl implements OrderAccommodationDetailService {
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
