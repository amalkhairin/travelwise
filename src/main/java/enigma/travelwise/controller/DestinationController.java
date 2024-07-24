package enigma.travelwise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import enigma.travelwise.model.Destination;
import enigma.travelwise.service.DestinationService;
import enigma.travelwise.utils.dto.DestionationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/destinations")
@RequiredArgsConstructor
public class DestinationController {
    private final DestinationService destinationService;
    @PostMapping
    public Destination create(@RequestBody DestionationDTO request) throws JsonProcessingException {
        return destinationService.create(request);
    }
}
