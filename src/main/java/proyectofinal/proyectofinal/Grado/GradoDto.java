package proyectofinal.proyectofinal.Grado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GradoDto {

    private Integer idGrado;
    private String nombreGrado;
}
