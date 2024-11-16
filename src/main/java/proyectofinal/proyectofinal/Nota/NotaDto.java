package proyectofinal.proyectofinal.Nota;

import java.util.Date;

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
    private Integer idMatricula;
    private Integer idCurso;
    private Float nota;
    private Date fechaNota;
}
