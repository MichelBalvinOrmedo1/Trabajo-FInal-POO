package proyectofinal.proyectofinal.Persona;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonaDto {
    private Integer dni;
    private String firstName;
    private String lastName;
    private String email;
    private String celular;
    private String tipoPersona;
    private UUID fileId;
    private String personaImagen;

}
