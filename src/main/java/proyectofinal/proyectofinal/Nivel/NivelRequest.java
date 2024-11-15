package proyectofinal.proyectofinal.Nivel;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class NivelRequest {

    @NotBlank
    private String nombreNivel;

}
