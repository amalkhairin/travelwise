package enigma.travelwise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import enigma.travelwise.model.Destination;
import enigma.travelwise.service.DestinationService;
import enigma.travelwise.utils.dto.DestionationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/destinations")
@RequiredArgsConstructor
public class DestinationController {
    private final DestinationService destinationService;
    @PostMapping
    public Destination create(@RequestBody DestionationDTO request) throws JsonProcessingException {
        return destinationService.create(request);
    }

    @PutMapping("/{id}")
    public Destination update(@RequestPart("file") List<MultipartFile> files, @PathVariable Long id) throws JsonProcessingException {
        return destinationService.uploadPhoto(files, id);
    }
}
