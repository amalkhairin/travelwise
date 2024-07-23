package enigma.travelwise.service.impl;

import enigma.travelwise.model.Destination;
import enigma.travelwise.repository.DestinationRepository;
import enigma.travelwise.service.DestinationService;
import enigma.travelwise.utils.dto.DestionationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository destinationRepository;

    @Override
    public Destination create(DestionationDTO req) {
        return null;
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
