package enigma.travelwise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Map;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accomodations")
public class Accomodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String location;

    @NotBlank
    private String category;

    @Column(columnDefinition = "jsonb")
    private Map<String, String> pictures;

    @Column(columnDefinition = "jsonb")
    private Map<String, Integer> category_prices;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

}
