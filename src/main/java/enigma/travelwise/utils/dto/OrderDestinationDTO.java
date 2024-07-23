package enigma.travelwise.utils.dto;

import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderDestinationDTO {
    private Long userId;
    private Integer totalPrice;
    private LocalDate orderDate;
    private String Status;

}
