package enigma.travelwise.service;
import enigma.travelwise.model.OrderDestination;
import enigma.travelwise.utils.dto.OrderDestinationDTO;

import java.util.List;

public interface OrderDestinationService {
    OrderDestination create (OrderDestinationDTO orderDestinationDTO);
    OrderDestination getById (Long id);
    List<OrderDestination> getAll ();


//    OrderDestination updateById ();
//    void deleteByid();
}
