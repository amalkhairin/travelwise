package enigma.travelwise.controller;

import enigma.travelwise.service.OrderAccommodationDetailService;
import enigma.travelwise.service.OrderDestinationDetailService;
import enigma.travelwise.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order_destination_details")
@RequiredArgsConstructor
public class OrderDestinationDetailController {

    private final OrderDestinationDetailService orderDestinationDetailService;


    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) String categoryTicket,
            @RequestParam(required = false) Long destinationId
    ) {
        return Response.renderJSON(orderDestinationDetailService.getAll(price, quantity, categoryTicket, destinationId), "SHOW ALL ORDER DESTINATION DETAIL");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(
            @PathVariable long id
    ) {
        return Response.renderJSON(orderDestinationDetailService.getOne(id), "SHOW ONE ORDER DESTINATION DETAIL");
    }
}
