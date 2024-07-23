package enigma.travelwise.service;

import enigma.travelwise.model.OrderDestination;

import java.util.List;

public interface OrderDestinationService {
    OrderDestination create ();
    OrderDestination getById ();
    List<OrderDestination> getall ();


//    OrderDestination updateById ();
//    void deleteByid();
}
