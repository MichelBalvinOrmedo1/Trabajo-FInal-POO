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
    private Integer idProfesor;
    private String nombreProfesor; // Nuevo campo
    private Integer idHorario;
    private String nombreHorario; // Nuevo campo
    private Integer idCategoria;
    private String nombreCategoria; // Nuevo campo
    private Integer idNivel;
    private String nombreNivel; // Nuevo campo

}
