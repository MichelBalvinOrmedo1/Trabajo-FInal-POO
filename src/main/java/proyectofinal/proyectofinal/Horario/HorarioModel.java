package proyectofinal.proyectofinal.Horario;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import proyectofinal.proyectofinal.aula.AulaModel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "horarios")
public class HorarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String dia;

    @Column(nullable = true)
    private Date horaInicio;

    @Column(nullable = true)
    private Date horaFin;

    @ManyToOne
    @JoinColumn(name = "codAula", referencedColumnName = "codAula")
    private AulaModel aula;
}
