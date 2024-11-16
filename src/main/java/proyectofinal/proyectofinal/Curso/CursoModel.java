package proyectofinal.proyectofinal.Curso;

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
import proyectofinal.proyectofinal.Categoria.CategoriaModel;
import proyectofinal.proyectofinal.Horario.HorarioModel;
import proyectofinal.proyectofinal.Nivel.NivelModel;
import proyectofinal.proyectofinal.Persona.PersonaModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cursos")
public class CursoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    @Column(nullable = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idProfesor", referencedColumnName = "dni")
    private PersonaModel profesor;

    @ManyToOne
    @JoinColumn(name = "idHorario", referencedColumnName = "id")
    private HorarioModel horario;

    @ManyToOne
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    private CategoriaModel categoria;

    @ManyToOne
    @JoinColumn(name = "idNivel", referencedColumnName = "idNivel")
    private NivelModel nivel;

}
