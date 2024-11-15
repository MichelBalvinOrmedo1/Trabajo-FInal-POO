package proyectofinal.proyectofinal.Grado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "grado")
public class GradoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGrado;

    @Column(nullable = true)
    private String nombreGrado;

}
