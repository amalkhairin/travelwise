package enigma.travelwise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import enigma.travelwise.utils.validator.NoSpaces;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Column(unique = true)
    @NoSpaces
    private String username;

    @Column(unique = true)
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // supaya tidak di-return di response API
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

//    @NotBlank(message = "Phone number must not be blank")
    private String phone_number;

    private String profile_picture;

//    @NotNull(message = "Latitude must not be null")
    private Double latitude;

//    @NotNull(message = "Longitude must not be null")
    private Double longitude;
}
