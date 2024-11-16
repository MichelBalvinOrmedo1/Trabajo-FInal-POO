package proyectofinal.proyectofinal.Nota;

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
import proyectofinal.proyectofinal.Curso.CursoModel;
import proyectofinal.proyectofinal.Matricula.MatriculaModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "notas")
public class NotaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNota;

    @ManyToOne
    @JoinColumn(name = "idMatricula", nullable = false)
    private MatriculaModel matricula;

    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false)
    private CursoModel curso;

    @Column(nullable = false)
    private Float nota;

    @Column(nullable = false)
    private Date fecha;
}
