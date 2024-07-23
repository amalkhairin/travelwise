package enigma.travelwise.service;

import enigma.travelwise.model.OrderDetailDestination;
import enigma.travelwise.model.OrderDetailDestination;

import java.util.List;

public interface OrderDetailDestinationService {
    OrderDetailDestination create ();
    OrderDetailDestination getById ();
    List<OrderDetailDestination> getall ();

//    OrderDetailDestination updateById ();
//    void deleteByid();
}
