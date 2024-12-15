package proyectofinal.proyectofinal.Matricula;

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
import proyectofinal.proyectofinal.Grado.GradoModel;
import proyectofinal.proyectofinal.Nivel.NivelModel;
import proyectofinal.proyectofinal.Persona.PersonaModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "matriculas")
public class MatriculaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMatricula;

    @ManyToOne
    @JoinColumn(name = "dniEstudiante", referencedColumnName = "dni")
    private PersonaModel persona;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idNivel", referencedColumnName = "idNivel")
    private NivelModel nivel;

    @ManyToOne
    @JoinColumn(name = "idGrado", referencedColumnName = "idGrado")
    private GradoModel grado;

}
