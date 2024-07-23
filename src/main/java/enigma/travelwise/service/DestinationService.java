package enigma.travelwise.service;

import enigma.travelwise.model.Destination;
import enigma.travelwise.utils.dto.DestionationDTO;

import java.util.List;

public interface DestinationService {
    Destination create(DestionationDTO req);
    List<Destination> getAll();
    Destination getById(Long id);
    Destination update(Long id, DestionationDTO req);
    void delete(Long id);
}
