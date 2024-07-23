package enigma.travelwise.service;

import enigma.travelwise.model.OrderDestination;

import java.util.List;

public interface OrderDestinationService {
    OrderDestination create ();
    OrderDestination updateById ();
    OrderDestination getById ();
    List<OrderDestination> getall ();
    void deleteByid();
}
