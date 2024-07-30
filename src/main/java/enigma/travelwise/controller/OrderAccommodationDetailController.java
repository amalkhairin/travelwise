package enigma.travelwise.controller;

import enigma.travelwise.service.OrderAccommodationDetailService;
import enigma.travelwise.service.OrderAccommodationService;
import enigma.travelwise.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/order_accommodation_details")
@RequiredArgsConstructor
public class OrderAccommodationDetailController {
    private final OrderAccommodationDetailService orderAccommodationDetailService;

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) String categoryRoom,
            @RequestParam(required = false) Long accommodationId
    ) {
        return Response.renderJSON(orderAccommodationDetailService.getAll(price, quantity, categoryRoom, accommodationId), "SHOW ALL ORDER ACCOMMODATION DETAIL");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(
            @PathVariable long id
    ) {
        return Response.renderJSON(orderAccommodationDetailService.getOne(id), "SHOW ONE ORDER ACCOMMODATION DETAIL");
    }

}
