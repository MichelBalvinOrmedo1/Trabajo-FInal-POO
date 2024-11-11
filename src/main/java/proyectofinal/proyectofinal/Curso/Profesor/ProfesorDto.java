package proyectofinal.proyectofinal.Curso.Profesor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfesorDto {
    private Integer dniProfesor;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private Integer celular;
}
