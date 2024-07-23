package enigma.travelwise.service;

import enigma.travelwise.model.OrderDetailDestination;
import enigma.travelwise.model.OrderDetailDestination;

import java.util.List;

public interface OrderDetailDestinationService {
    OrderDetailDestination create ();
    OrderDetailDestination updateById ();
    OrderDetailDestination getById ();
    List<OrderDetailDestination> getall ();
    void deleteByid();
}
