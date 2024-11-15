package proyectofinal.proyectofinal.Matricula;

import java.sql.Date;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
public class MatriculaRequest {

    @NotNull
    private Integer dniEstudiante;

    @NotNull
    private Integer idNivel;

    @NotNull
    private Integer idGrado;

    @NotNull
    private Date fecha;

}
