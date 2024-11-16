package proyectofinal.proyectofinal.Matricula.DetalleMatricula;

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
public class DetalleMatriculaRequest {

    @NotNull
    private Integer idMatricula;

    @NotNull
    private Integer idCurso;
}
