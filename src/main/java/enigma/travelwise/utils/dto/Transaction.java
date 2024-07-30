package enigma.travelwise.utils.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @JsonProperty("transaction_details")
    TransactionDetails transactionDetails;
    @JsonProperty("customer_details")
    CustomerDetails customerDetails;
    @JsonProperty("expiry")
    Expiry expiry;
//    @JsonProperty("item_details")
//    ItemDetails itemDetails;

    @Getter
    @Setter
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TransactionDetails {
        String order_id;
        Integer gross_amount;
    }

    @Getter
    @Setter
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CustomerDetails {
        String first_name;
        String email;
        String phone_number;
    }

    @Getter
    @Setter
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Expiry {
        @JsonProperty("unit")
        String unit;
        @JsonProperty("duration")
        Integer duration;
    }

//    @Getter
//    @Setter
//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @Builder
//    public static class ItemDetails {
//
//        List<Item> items;
//
//        @Getter
//        @Setter
//        @Data
//        @AllArgsConstructor
//        @NoArgsConstructor
//        @Builder
//        public static class Item {
//            String id;
//            String name;
//            Integer quantity;
//            Integer price;
//        }
//
//    }
}
