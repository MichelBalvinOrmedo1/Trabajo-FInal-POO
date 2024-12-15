package proyectofinal.proyectofinal.aula;

import org.springframework.validation.annotation.Validated;

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
public class AulaRequest {

    @NotNull
    private Integer cantActual;

    @NotNull
    private Integer cantMaxima;

    @NotNull
    private String estado;

}
