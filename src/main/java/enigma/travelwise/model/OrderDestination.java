package enigma.travelwise.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "order_destionation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderDestination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //user id ManyToOne
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userId;

    @Column (name = "totalPrice")
    private Integer totalPrice;

    @Column (name = "orderDate")
    private LocalDate orderDate;

    @Column (name = "status")
    private String status;




}
