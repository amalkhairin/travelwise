package enigma.travelwise.service;

import enigma.travelwise.model.OrderDetailDestination;
import enigma.travelwise.model.OrderDetailDestination;
import enigma.travelwise.utils.dto.OrderDetailDestinationDTO;

import java.util.List;

public interface OrderDetailDestinationService {
    OrderDetailDestination create (OrderDetailDestinationDTO orderDetailDestinationDTO);
    OrderDetailDestination getById (Long id);
    List<OrderDetailDestination> getAll ();

//    OrderDetailDestination updateById ();
//    void deleteByid();
}
