package enigma.travelwise.service;

import enigma.travelwise.model.OrderAccommodationDetail;
import enigma.travelwise.model.OrderDestinationDetail;
import enigma.travelwise.utils.dto.OrderAccommodationDetailDTO;
import enigma.travelwise.utils.dto.OrderDestinationDetailDTO;

import java.util.List;

public interface OrderDestinationDetailService {
    OrderDestinationDetail create(OrderDestinationDetailDTO request);
    List<OrderDestinationDetail> getAll(Integer price, Integer quantity, String categoryTicket, Long destinationId);
    OrderDestinationDetail getOne(Long id);

}
