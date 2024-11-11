package proyectofinal.proyectofinal.Nota;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotaDto {
    private Integer idNota;
    private Integer nombreGrado;
}
