package proyectofinal.proyectofinal.Curso;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class CursoRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private Integer idProfesor;

    @NotBlank
    private Integer idHorario;

    @NotBlank
    private Integer idCategoria;

    @NotBlank
    private Integer idNivel;
}
