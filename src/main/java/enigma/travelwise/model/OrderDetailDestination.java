package enigma.travelwise.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderDetailDestination {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    //order_destination_id manytoone orderdestination
    @ManyToOne
    @JoinColumn(name="orderDestinationId")
    private OrderDestination orderDestinationId;

    //destination_id manytoone destination
    @ManyToOne
    @JoinColumn(name="destinationId")
    private Destination destinationId;


    @Column (name = "price")
    private Integer price;

    @Column (name = "quantity")
    private Integer quantity;

    @Column (name ="categoryTicket")
    private String categoryTicket;


}
