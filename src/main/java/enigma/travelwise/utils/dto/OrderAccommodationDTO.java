package enigma.travelwise.utils.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderAccommodationDTO {
    private Long userId;
    private List<OrderAccommodationDetailDTO> orderAccommodationDetails;
}
