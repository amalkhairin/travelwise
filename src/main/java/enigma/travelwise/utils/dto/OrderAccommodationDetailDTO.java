package enigma.travelwise.utils.dto;

import enigma.travelwise.model.OrderAccommodation;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderAccommodationDetailDTO {
    private Integer price;
    private Integer quantity;
    private Integer accommodationId;
    private OrderAccommodation orderAccommodation;
}
