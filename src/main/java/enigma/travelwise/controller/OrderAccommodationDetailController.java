package enigma.travelwise.controller;

import enigma.travelwise.service.OrderAccommodationDetailService;
import enigma.travelwise.service.OrderAccommodationService;
import enigma.travelwise.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/order_accommodation_details")
@RequiredArgsConstructor
public class OrderAccommodationDetailController {
    private final OrderAccommodationDetailService orderAccommodationDetailService;

    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault Pageable pageable,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) String categoryRoom,
            @RequestParam(required = false) Long accommodationId
    ) {
        return Response.renderJSON(orderAccommodationDetailService.getAll(pageable, price, quantity, categoryRoom, accommodationId), "SHOW ALL ORDER ACCOMMODATION DETAIL");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(
            @PathVariable long id
    ) {
        return Response.renderJSON(orderAccommodationDetailService.getOne(id), "SHOW ONE ORDER ACCOMMODATION DETAIL");
    }

}
