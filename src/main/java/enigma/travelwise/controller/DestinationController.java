package enigma.travelwise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import enigma.travelwise.model.Destination;
import enigma.travelwise.service.DestinationService;
import enigma.travelwise.utils.dto.DestionationDTO;
import enigma.travelwise.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/destinations")
@RequiredArgsConstructor
public class DestinationController {
    private final DestinationService destinationService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody DestionationDTO request) throws JsonProcessingException {
        return Response.renderJSON(destinationService.create(request), "DESTINATION CREATED");
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return Response.renderJSON(destinationService.getAll());
    }

    @GetMapping("/weather")
    public ResponseEntity<?> getAllWithWeather() {
        return Response.renderJSON(destinationService.getAllWithWeather());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return Response.renderJSON(destinationService.getById(id));
    }

    @GetMapping("/{id}/weather")
    public ResponseEntity<?> getWithWeatherById(@PathVariable Long id) {
        return Response.renderJSON(destinationService.getWithWeatherById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestPart("file") List<MultipartFile> files, @PathVariable Long id) throws JsonProcessingException {
        return Response.renderJSON(destinationService.uploadPhoto(files, id), "DESTINATION UPDATED");
    }

}
