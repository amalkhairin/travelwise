package enigma.travelwise.controller;

import enigma.travelwise.model.OrderAccommodation;
import enigma.travelwise.service.OrderAccommodationService;
import enigma.travelwise.utils.dto.OrderAccommodationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order_accommodations")
@RequiredArgsConstructor
public class OrderAccommodationController {
    private final OrderAccommodationService orderAccommodationService;

    @PostMapping
    public OrderAccommodation create(@RequestBody OrderAccommodationDTO request) {
        return orderAccommodationService.create(request);
    }
    @GetMapping
    public List<OrderAccommodation> getAll() {
        return orderAccommodationService.getAll();
    }
}
