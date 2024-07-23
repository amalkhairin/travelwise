package enigma.travelwise.repository;

import enigma.travelwise.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestionationRepository extends JpaRepository<Destination, Long> {
}
