package proyectofinal.proyectofinal.Matricula.DetalleMatricula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleMatriculaDto {
    private Integer idMatricula;
    private Integer idCurso;
}
