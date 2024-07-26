package enigma.travelwise.repository;

import enigma.travelwise.model.OrderAccommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAccommodationRepository extends JpaRepository<OrderAccommodation, Long>, JpaSpecificationExecutor<OrderAccommodation> {
}
