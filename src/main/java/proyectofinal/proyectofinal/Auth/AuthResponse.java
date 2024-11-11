package proyectofinal.proyectofinal.Auth;

import proyectofinal.proyectofinal.Profile.ProfileDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    String token;

    String userName;

    ProfileDTO profile;

}
