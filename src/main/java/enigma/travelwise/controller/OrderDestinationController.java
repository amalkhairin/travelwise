package enigma.travelwise.controller;

import enigma.travelwise.service.OrderDestinationService;
import enigma.travelwise.utils.dto.OrderDestinationDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderDestination")
@RequiredArgsConstructor
public class OrderDestinationController {
    private OrderDestinationService orderDestinationService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody OrderDestinationDTO orderDestinationDTO){
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
