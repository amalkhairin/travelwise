package enigma.travelwise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import enigma.travelwise.service.AccommodationService;
import enigma.travelwise.utils.dto.AccommodationDTO;
import enigma.travelwise.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    @PutMapping("/update-photo/{id}")
    private ResponseEntity<?> updatePhoto(@RequestPart("file") List<MultipartFile> files,
                                          @PathVariable Long id) throws JsonProcessingException {
        return Response.renderJSON(accommodationService.updatePhoto(files, id), "PHOTOS UPLOADED");
    }

    @GetMapping
    private ResponseEntity<?> getAll(@PageableDefault Pageable pageable,
                                     @RequestParam(required = false) String name,
                                     @RequestParam(required = false) String category,
                                     @RequestParam(required = false) String location) {
        return Response.renderJSON(accommodationService.getAll(pageable, name, location, category), "SHOW ALL ACCOMMODATIONS");
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        return Response.renderJSON(accommodationService.getById(id), "SHOW ACCOMMODATION BY ID");
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<?> update(@RequestBody AccommodationDTO request,
                                     @PathVariable Long id) {
        return Response.renderJSON(accommodationService.update(request, id), "ACCOMMODATION UPDATED");
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        return Response.renderJSON(accommodationService.deleteById(id), "ACCOMMODATION DELETED");
    }


}
