package proyectofinal.proyectofinal.Horario;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HorarioDto {

    private Integer id;
    private String dia;
    private Date horaInicio;
    private Date horaFin;
    private Integer codAula;

}
