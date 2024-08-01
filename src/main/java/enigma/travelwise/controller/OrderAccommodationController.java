package enigma.travelwise.controller;

import enigma.travelwise.model.OrderAccommodation;
import enigma.travelwise.service.OrderAccommodationService;
import enigma.travelwise.service.TransactionService;
import enigma.travelwise.utils.dto.OrderAccommodationDTO;
import enigma.travelwise.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order_accommodations")
@RequiredArgsConstructor
public class OrderAccommodationController {
    private final OrderAccommodationService orderAccommodationService;
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderAccommodationDTO request) {
        return Response.renderJSON(transactionService.createOrderAccommodation(request), "CREATE ORDER ACCOMMODATION");
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault Pageable pageable,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Integer totalPrice,
            @RequestParam(required = false) LocalDate checkIn,
            @RequestParam(required = false) LocalDate checkOut
    ) {
        return Response.renderJSON(orderAccommodationService.getAll(pageable, userId, totalPrice, checkIn, checkOut), "SHOW ALL ORDER ACCOMMODATION");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(
            @PathVariable String id
    ) {
        return Response.renderJSON(orderAccommodationService.getOne(id), "SHOW ONE ORDER ACCOMMODATION");
    }
}
