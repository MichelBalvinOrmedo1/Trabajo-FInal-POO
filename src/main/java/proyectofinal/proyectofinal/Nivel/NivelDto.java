package proyectofinal.proyectofinal.Nivel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class NivelDto {
    private Integer idNivel;
    private String nombreNivel;
}
