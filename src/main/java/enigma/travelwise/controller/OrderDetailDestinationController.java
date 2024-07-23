package enigma.travelwise.controller;

import enigma.travelwise.service.OrderDetailDestinationService;
import enigma.travelwise.utils.dto.OrderDetailDestinationDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderDetailDestination")
@RequiredArgsConstructor
public class OrderDetailDestinationController {
    private OrderDetailDestinationService orderDetailDestinationService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody OrderDetailDestinationDTO orderDetailDestinationDTO){
        return null;
    }

    @GetMapping
    public ResponseEntity<?>getAll(){
        return null;
    }

    @GetMapping
    public ResponseEntity<?>getById(@PathVariable Long id){
        return null;
    }


}
