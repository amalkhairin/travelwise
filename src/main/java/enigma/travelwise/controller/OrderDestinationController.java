package enigma.travelwise.controller;

import enigma.travelwise.model.OrderDestination;
import enigma.travelwise.service.OrderAccommodationService;
import enigma.travelwise.service.OrderDestinationService;
import enigma.travelwise.utils.dto.OrderAccommodationDTO;
import enigma.travelwise.utils.dto.OrderDestinationDTO;
import enigma.travelwise.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/order_destinations")
@RequiredArgsConstructor
public class OrderDestinationController {
    private final OrderDestinationService orderDestinationsService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderDestinationDTO request) {
        return Response.renderJSON(orderDestinationsService.create(request), "ORDER DESTINATION CREATED");
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Integer totalPrice,
            @RequestParam(required = false) LocalDate orderDate
    ) {
        return Response.renderJSON(orderDestinationsService.getAll(userId, totalPrice, orderDate), "SHOW ALL ORDER ACCOMMODATION");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(
            @PathVariable String id
    ) {
        return Response.renderJSON(orderDestinationsService.getOne(id), "SHOW ONE ORDER ACCOMMODATION");
    }
}
