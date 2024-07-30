package enigma.travelwise.utils.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetailDTO {
    @JsonProperty("status_code")
    private String statusCode;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("gross_amount")
    private int grossAmount;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("payment_type")
    private String paymentType;
    @JsonProperty("fraud_status")
    private String fraudStatus;
    @JsonProperty("transaction_status")
    private String transactionStatus;
    @JsonProperty("channel_response_message")
    private String channelResponseMessage;
}
