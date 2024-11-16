package proyectofinal.proyectofinal.Matricula.DetalleMatricula;

import jakarta.persistence.*;
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
@Table(name = "detalle_matricula")
@IdClass(DetalleMatriculaId.class)
public class DetalleMatriculaModel {
    @Id
    @ManyToOne
    @JoinColumn(name = "idMatricula", referencedColumnName = "idMatricula")
    private MatriculaModel matricula;

    @Id
    @ManyToOne
    @JoinColumn(name = "idCurso", referencedColumnName = "idCurso")
    private CursoModel curso;
}
