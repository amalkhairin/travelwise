package enigma.travelwise.utils.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccommodationDTO {
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
