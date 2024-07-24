package enigma.travelwise.service;

import enigma.travelwise.model.Accommodation;
import enigma.travelwise.utils.dto.AccommodationChangePictureDTO;
import enigma.travelwise.utils.dto.AccommodationDTO;

import java.util.List;

public interface AccommodationService {
    Accommodation create(AccommodationDTO request);
    List<Accommodation> getAll(String name, String location, String category);
    Accommodation getById(Long id);
    Accommodation update(AccommodationDTO request, Long id);
    void changePicture(AccommodationChangePictureDTO request, Long id);
    void deleteById(Long id);
}
