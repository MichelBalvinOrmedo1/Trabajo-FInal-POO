package proyectofinal.proyectofinal.Curso.CursoProfesor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoProfesorDto {
    private Integer idCurso;
    private Integer dniProfesor;
}
