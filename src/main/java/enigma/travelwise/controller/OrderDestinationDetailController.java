package enigma.travelwise.controller;

import enigma.travelwise.service.OrderAccommodationDetailService;
import enigma.travelwise.service.OrderDestinationDetailService;
import enigma.travelwise.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order_destination_details")
@RequiredArgsConstructor
public class OrderDestinationDetailController {

    private final OrderDestinationDetailService orderDestinationDetailService;


    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault Pageable pageable,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) String categoryTicket,
            @RequestParam(required = false) Long destinationId
    ) {
        return Response.renderJSON(orderDestinationDetailService.getAll(pageable, price, quantity, categoryTicket, destinationId), "SHOW ALL ORDER DESTINATION DETAIL");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(
            @PathVariable long id
    ) {
        return Response.renderJSON(orderDestinationDetailService.getOne(id), "SHOW ONE ORDER DESTINATION DETAIL");
    }
}
