package enigma.travelwise.controller;

import enigma.travelwise.model.OrderDestination;
import enigma.travelwise.model.OrderDetailDestination;
import enigma.travelwise.service.OrderDetailDestinationService;
import enigma.travelwise.utils.dto.OrderDetailDestinationDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order_detail_destinations")
@RequiredArgsConstructor
public class OrderDetailDestinationController {
    private OrderDetailDestinationService orderDetailDestinationService;

    @PostMapping
    public OrderDetailDestination create(@Valid @RequestBody OrderDetailDestinationDTO orderDetailDestinationDTO){
        return orderDetailDestinationService.create(orderDetailDestinationDTO);
    }

    @GetMapping
    public List<OrderDetailDestination> getAll(){
        return orderDetailDestinationService.getAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?>getById(@PathVariable Long id){
        return null;
    }


}
