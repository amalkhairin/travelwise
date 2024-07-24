package enigma.travelwise.controller;

import enigma.travelwise.model.Accommodation;
import enigma.travelwise.service.AccommodationService;
import enigma.travelwise.utils.dto.AccommodationDTO;
import enigma.travelwise.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accommodations")
@RequiredArgsConstructor
public class AccommodationController {
    @Autowired
    private final AccommodationService accommodationService;

    @PostMapping
    private ResponseEntity<?> create(@RequestBody AccommodationDTO request) {
        return Response.renderJSON(accommodationService.create(request), "ACCOMMODATION CREATED");
    }
}
