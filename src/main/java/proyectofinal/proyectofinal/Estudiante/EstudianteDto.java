package proyectofinal.proyectofinal.Estudiante;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstudianteDto {
    private Integer dniEstudiante;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private String celular;
}
