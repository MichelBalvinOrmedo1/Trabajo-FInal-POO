package proyectofinal.proyectofinal.aula;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aulas")
public class AulaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codAula;

    @Column(nullable = true)
    private Integer cantActual;

    @Column(nullable = true)
    private Integer cantMaxima;

    @Column(nullable = true)
    private String estado;

    @PrePersist
    protected void onCreate() {
        if (estado == null) {
            estado = "DISPONIBLE";
        }
    }

}
