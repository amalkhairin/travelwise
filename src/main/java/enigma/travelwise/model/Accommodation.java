package enigma.travelwise.model;

import enigma.travelwise.utils.JsonConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accomodations")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank
    private String name;

//    @NotBlank
    private String description;

//    @NotBlank
    private String location;

//    @NotBlank
    private String category;

    @JdbcTypeCode(SqlTypes.JSON)
    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> pictures;

    @JdbcTypeCode(SqlTypes.JSON)
    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Integer> category_prices;

//    @NotNull
    private Double latitude;

//    @NotNull
    private Double longitude;

}
