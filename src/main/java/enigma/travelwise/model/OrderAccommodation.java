package enigma.travelwise.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_accommodation")//nama table di databse
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderAccommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer totalPrice;

    private LocalDate checkIn;

    private LocalDate checkOut;

    // field user

    @OneToMany(mappedBy = "order")
    private List<OrderAccommodationDetail> accommodationDetails = new ArrayList<>();
}
