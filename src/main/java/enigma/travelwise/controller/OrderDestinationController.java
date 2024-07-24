package enigma.travelwise.controller;

import enigma.travelwise.model.OrderDestination;
import enigma.travelwise.model.OrderDetailDestination;
import enigma.travelwise.service.OrderDestinationService;
import enigma.travelwise.utils.dto.OrderDestinationDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDestination")
@RequiredArgsConstructor
public class OrderDestinationController {
    private OrderDestinationService orderDestinationService;

    @PostMapping
    public OrderDestination create(@Valid @RequestBody OrderDestinationDTO orderDestinationDTO){
        return orderDestinationService.create(orderDestinationDTO);
    }

    @GetMapping
    public List<OrderDestination> getAll(){
        return orderDestinationService.getall();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getById(@PathVariable Long id){
        return null;
    }
}
