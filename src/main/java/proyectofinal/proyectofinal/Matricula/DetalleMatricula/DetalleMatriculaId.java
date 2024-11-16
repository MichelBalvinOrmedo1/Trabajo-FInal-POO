package proyectofinal.proyectofinal.Matricula.DetalleMatricula;

import java.io.Serializable;
import java.util.Objects;

public class DetalleMatriculaId implements Serializable {
    private Integer matricula;
    private Integer curso;

    // Constructor, getters, setters, equals y hashCode
    public DetalleMatriculaId() {
    }

    public DetalleMatriculaId(Integer matricula, Integer curso) {
        this.matricula = matricula;
        this.curso = curso;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DetalleMatriculaId that = (DetalleMatriculaId) o;
        return Objects.equals(matricula, that.matricula) && Objects.equals(curso, that.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, curso);
    }
}