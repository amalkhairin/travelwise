package enigma.travelwise.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import enigma.travelwise.model.Accommodation;
import enigma.travelwise.repository.AccommodationRepository;
import enigma.travelwise.service.AccommodationService;
import enigma.travelwise.service.CloudinaryService;
import enigma.travelwise.utils.dto.AccommodationChangePictureDTO;
import enigma.travelwise.utils.dto.AccommodationDTO;
import enigma.travelwise.utils.specification.AccommodationSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccommodationServiceImpl implements AccommodationService {
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private AccommodationRepository accommodationRepository;

    @Override
    public Accommodation create(AccommodationDTO request) {
        Accommodation accommodation = new Accommodation();
        accommodation.setName(request.getName());
        accommodation.setDescription(request.getDescription());
        accommodation.setLocation(request.getLocation());
        accommodation.setCategory(request.getCategory());
        accommodation.setCategory_prices(request.getCategory_prices());
        accommodation.setLatitude(request.getLatitude());
        accommodation.setLongitude(request.getLongitude());
//        Map<String, String> map = new HashMap<>();
//        for (int i = 0; i < request.getPictures().size(); i++) {
//            String url = cloudinaryService.uploadFile(request.getPictures().get(i),"travelwise_accommodation");
//            map.put("pict_1" + i, url);
//        }
//        accommodation.setPictures(map);
        return accommodationRepository.save(accommodation);
    }

    @Override
    public List<Accommodation> getAll(String name, String location, String category) {
        Specification<Accommodation> specification = AccommodationSpecification.getSpecification(name, location, category);
        return accommodationRepository.findAll(specification);
    }

    @Override
    public Accommodation getById(Long id) {
        return accommodationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ACCOMMODATION WITH ID + " + id + " NOT FOUND"));
    }

    @Override
    public Accommodation update(AccommodationDTO request, Long id) {
        Accommodation updateAccomm = this.getById(id);
        updateAccomm.setName(request.getName());
        updateAccomm.setDescription(request.getDescription());
        updateAccomm.setLocation(request.getLocation());
        updateAccomm.setCategory(request.getCategory());
        updateAccomm.setCategory_prices(request.getCategory_prices());
        updateAccomm.setLatitude(request.getLatitude());
        updateAccomm.setLongitude(request.getLongitude());
        // picture tidak diganti saat update, karena ada fiturnya sendiri
//        updateAccomm.setPictures(updateAccomm.getPictures());
        return accommodationRepository.save(updateAccomm);
    }

    @Override
    public void changePicture(AccommodationChangePictureDTO request, Long id) {
        Accommodation changePictureAccomm = this.getById(id);
//        Map<String, String> map = new HashMap<>();
//        for (int i = 0; i < request.getPictures().size(); i++) {
//            String url = cloudinaryService.uploadFile(request.getPictures().get(i),"travelwise_accommodation");
//            map.put("pict_1" + i, url);
//        }
//        changePictureAccomm.setPictures(map);
        // yang lainnya tidak diganti karena sudah diprovide di fitur update
        changePictureAccomm.setName(changePictureAccomm.getName());
        changePictureAccomm.setDescription(changePictureAccomm.getDescription());
        changePictureAccomm.setLocation(changePictureAccomm.getLocation());
        changePictureAccomm.setCategory(changePictureAccomm.getCategory());
        changePictureAccomm.setCategory_prices(changePictureAccomm.getCategory_prices());
        changePictureAccomm.setLatitude(changePictureAccomm.getLatitude());
        changePictureAccomm.setLongitude(changePictureAccomm.getLongitude());
        accommodationRepository.save(changePictureAccomm);
    }

    @Override
    public void deleteById(Long id) {
        Accommodation deleteAccomm = this.getById(id);
        accommodationRepository.delete(deleteAccomm);
    }
}
