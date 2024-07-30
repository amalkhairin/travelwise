package enigma.travelwise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import enigma.travelwise.service.DestinationService;
import enigma.travelwise.utils.dto.DestionationDTO;
import enigma.travelwise.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/destinations")
@RequiredArgsConstructor
public class DestinationController {
    private final DestinationService destinationService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody DestionationDTO request) throws JsonProcessingException {
        return Response.renderJSON(destinationService.create(request), "DESTINATION CREATED");
    }

    @GetMapping
    public ResponseEntity<?> getAll(@PageableDefault Pageable pageable,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) String category,
                                    @RequestParam(required = false) String location) {
        return Response.renderJSON(destinationService.getAll(pageable, name, category, location));
    }

    @GetMapping("/weather")
    public ResponseEntity<?> getAllWithWeather(@PageableDefault Pageable pageable,
                                               @RequestParam(required = false) String name,
                                               @RequestParam(required = false) String category,
                                               @RequestParam(required = false) String location) {
        return Response.renderJSON(destinationService.getAllWithWeather(pageable, name, category, location));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return Response.renderJSON(destinationService.getById(id));
    }

    @GetMapping("/{id}/weather")
    public ResponseEntity<?> getWithWeatherById(@PathVariable Long id) {
        return Response.renderJSON(destinationService.getWithWeatherById(id));
    }

    @PutMapping("/{id}/photos")
    public ResponseEntity<?> updatePhoto(@RequestPart("file") List<MultipartFile> files, @PathVariable Long id) throws JsonProcessingException {
        return Response.renderJSON(destinationService.uploadPhoto(files, id), "DESTINATION UPDATED");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DestionationDTO request, @PathVariable Long id) throws JsonProcessingException {
        return Response.renderJSON(destinationService.update(id, request), "DESTINATION UPDATED");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        destinationService.delete(id);
        return Response.renderJSON(null, "DESTINATION DELETED");
    }

}
