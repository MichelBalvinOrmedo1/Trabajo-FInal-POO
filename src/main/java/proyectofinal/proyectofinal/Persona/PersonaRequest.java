package proyectofinal.proyectofinal.Persona;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class PersonaRequest {

    @NotNull
    private Integer dni;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String celular;

    @NotBlank
    private String tipoPersona;

    @NotNull
    private UUID fileId;

}
