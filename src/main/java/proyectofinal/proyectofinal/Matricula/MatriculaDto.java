package proyectofinal.proyectofinal.Matricula;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatriculaDto {

    private Integer idMatricula;
    private Integer dniEstudiante;
    private Date fecha;
    private Integer idNivel;
    private Integer idGrado;
}
