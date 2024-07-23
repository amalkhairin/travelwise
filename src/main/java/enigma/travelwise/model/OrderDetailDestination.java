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
//    @ManyToOne
//    @JoinColumn(name="order_destination")
//

    //destination_id manytoone destination
    @ManyToOne
    @JoinColumn(name="destination_id")
    private Destination destination;


    @Column (name = "price")
    private Integer price;

    @Column (name = "quantity")
    private Integer quantity;

    @Column (name ="categoryTicket")
    private String categoryTicket;


}
