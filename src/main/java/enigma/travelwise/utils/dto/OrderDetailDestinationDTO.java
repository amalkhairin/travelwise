package enigma.travelwise.utils.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderDetailDestinationDTO {
    private Long orderDestinationId;
    private Long destinationId;
    private Integer price;
    private Integer quantity;
    private String categoryTicket;
}
