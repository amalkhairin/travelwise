package enigma.travelwise.service.impl;

import enigma.travelwise.model.Destination;
import enigma.travelwise.repository.DestinationRepository;
import enigma.travelwise.service.CloudinaryService;
import enigma.travelwise.service.DestinationService;
import enigma.travelwise.utils.dto.DestionationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class DestinationServiceImpl implements DestinationService {
    private final CloudinaryService cloudinaryService;
    private final DestinationRepository destinationRepository;

    @Override
    public Destination create(DestionationDTO req) {
        Destination destination = Destination.builder()
                .name(req.getName())
                .categories(req.getCategories())
                .description(req.getDescription())
                .locations(req.getLocations())
                .category_prices(req.getCategory_prices())
                .latitude(req.getLatitude())
                .longitude(req.getLongitude())
                .build();
        Map<String, String> map_url = new HashMap<>();
        for (int i = 0; i < req.getPictures().size(); i++) {
            String url = cloudinaryService.uploadFile(req.getPictures().get(i), "travelwise_destinations");
            map_url.put("pict_" + i, url);
        }

        destination.setPictures(map_url);
        return destinationRepository.save(destination);

    }

    @Override
    public List<Destination> getAll() {
        return List.of();
    }

    @Override
    public Destination getById(Long id) {
        return null;
    }

    @Override
    public Destination update(Long id, DestionationDTO req) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
