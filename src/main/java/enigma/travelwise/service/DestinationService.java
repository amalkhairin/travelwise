package enigma.travelwise.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import enigma.travelwise.model.Destination;
import enigma.travelwise.utils.dto.CustomDestinationResponse;
import enigma.travelwise.utils.dto.DestionationDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DestinationService {
    Destination create(DestionationDTO req) throws JsonProcessingException;
    Destination uploadPhoto(List<MultipartFile> files, Long id);
    List<Destination> getAll();
    List<CustomDestinationResponse> getAllWithWeather();
    Destination getById(Long id);
    CustomDestinationResponse getByIdWithWeather(Long id);
    Destination update(Long id, DestionationDTO req);
    void delete(Long id);
}
