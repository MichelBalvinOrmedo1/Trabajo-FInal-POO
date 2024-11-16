package proyectofinal.proyectofinal.Nota;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class NotaRequest {

    @NotNull(message = "idMatricula no puede ser nulo")
    private Integer idMatricula;

    @NotNull(message = "idCurso no puede ser nulo")
    private Integer idCurso;

    @NotNull(message = "nota no puede ser nulo")
    @Min(value = 0, message = "nota debe ser mayor o igual a 0")
    private Float nota;

    @NotNull(message = "fechaNota no puede ser nulo")
    @PastOrPresent(message = "fechaNota debe ser una fecha pasada o presente")
    private Date fechaNota;

}
