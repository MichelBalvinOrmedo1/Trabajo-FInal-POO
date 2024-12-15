package proyectofinal.proyectofinal.Matricula;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import proyectofinal.proyectofinal.Persona.PersonaDto;

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
    private PersonaDto estudiante;
    private String nombreNivel;
    private String nombreGrado;
}
