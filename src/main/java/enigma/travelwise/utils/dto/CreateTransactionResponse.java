package enigma.travelwise.utils.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTransactionResponse {
    @JsonProperty("token")
    String token;
    @JsonProperty("redirect_url")
    String redirectUrl;
}
