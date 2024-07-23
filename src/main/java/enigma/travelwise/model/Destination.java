package enigma.travelwise.model;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.sql.SQLType;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Destinations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String locations;

    @Column(columnDefinition = "jsonb")
    private Map<String, Integer> categories;

    @Column(columnDefinition = "jsonb")
    private Map<String, String> pictures;

    private Double latitude;
    private Double longitude;

    @Column(columnDefinition = "jsonb")
    private Map<String, Integer> category_prices;


}
