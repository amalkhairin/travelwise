package enigma.travelwise.repository;

import enigma.travelwise.model.Accomodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccommodationRepository extends JpaRepository<Accomodation, Long>, JpaSpecificationExecutor<Accomodation> {

}
