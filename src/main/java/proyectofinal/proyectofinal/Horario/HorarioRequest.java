package proyectofinal.proyectofinal.Horario;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class HorarioRequest {

    @NotNull
    private String dia;

    @NotNull
    private Date horaInicio;

    @NotNull
    private Date horaFin;

}
