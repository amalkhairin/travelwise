package enigma.travelwise.service;

import enigma.travelwise.model.Accommodation;
import enigma.travelwise.utils.dto.AccommodationChangePictureDTO;
import enigma.travelwise.utils.dto.AccommodationDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AccommodationService {
    Accommodation create(AccommodationDTO request);
    Accommodation uploadPhoto(List<MultipartFile> files, Long id);
    List<Accommodation> getAll(String name, String location, String category);
    Accommodation getById(Long id);
    Accommodation update(AccommodationDTO request, Long id);
    void changePicture(AccommodationChangePictureDTO request, Long id);
    void deleteById(Long id);
}
