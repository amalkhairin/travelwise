package enigma.travelwise.service.impl;

import enigma.travelwise.model.Accommodation;
import enigma.travelwise.repository.AccommodationRepository;
import enigma.travelwise.service.AccommodationService;
import enigma.travelwise.service.CloudinaryService;
import enigma.travelwise.utils.dto.AccommodationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private AccommodationRepository accommodationRepository;

    @Override
    public ResponseEntity<Map> create(AccommodationDTO request) {
        return null;
    }

    @Override
    public List<Accommodation> getAll() {
        return List.of();
    }

    @Override
    public Accommodation getById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Map> update(AccommodationDTO request, Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
