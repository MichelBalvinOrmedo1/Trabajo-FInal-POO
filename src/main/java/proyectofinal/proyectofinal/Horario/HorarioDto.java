package proyectofinal.proyectofinal.Horario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HorarioDto {

    private Integer idHorario;
    private String dia;
    private String horaInicio;
    private String horaFin;
    private String aula;

}
