package proyectofinal.proyectofinal.aula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AulaDto {

    private Integer codAula;
    private Integer cantActual;
    private Integer cantMaxima;
    private String estado;
}
