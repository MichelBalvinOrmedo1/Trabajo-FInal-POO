package proyectofinal.proyectofinal.Curso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoDto {

    private Integer idCurso;
    private String nombre;
    private Integer idCategoria;
}
