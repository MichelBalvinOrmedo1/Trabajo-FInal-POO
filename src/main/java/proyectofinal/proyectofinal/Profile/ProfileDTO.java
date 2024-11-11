package proyectofinal.proyectofinal.Profile;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDTO {

    private Integer dni;
    private String firstName;
    private String lastName;
    private String email;
    private UUID fileId;
    private String profileImage;

}
