package enigma.travelwise.service;

import enigma.travelwise.model.Accommodation;
import enigma.travelwise.utils.dto.AccommodationDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface AccommodationService {
    ResponseEntity<Map> create(AccommodationDTO request);
    List<Accommodation> getAll();
    Accommodation getById(Integer id);
    ResponseEntity<Map> update(AccommodationDTO request, Integer id);
    void deleteById(Integer id);
}
