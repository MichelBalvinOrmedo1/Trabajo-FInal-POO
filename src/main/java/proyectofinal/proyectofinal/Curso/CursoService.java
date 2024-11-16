package proyectofinal.proyectofinal.Curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectofinal.proyectofinal.Categoria.CategoriaModel;
import proyectofinal.proyectofinal.Categoria.CategoriaRepository;
import proyectofinal.proyectofinal.Horario.HorarioModel;
import proyectofinal.proyectofinal.Horario.HorarioRepository;
import proyectofinal.proyectofinal.Nivel.NivelModel;
import proyectofinal.proyectofinal.Nivel.NivelRepository;
import proyectofinal.proyectofinal.Persona.PersonaModel;
import proyectofinal.proyectofinal.Persona.PersonaRepository;
import proyectofinal.proyectofinal.exception.ResourceNotFoundException;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private NivelRepository nivelRepository;

    public CursoDto createCurso(CursoRequest cursoRequest) {

        PersonaModel profesor = personaRepository.findById(cursoRequest.getIdProfesor())
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado"));

        HorarioModel horario = horarioRepository.findById(cursoRequest.getIdHorario())
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado"));

        CategoriaModel categoria = categoriaRepository.findById(cursoRequest.getIdCategoria())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria no encontrada"));

        NivelModel nivel = nivelRepository.findById(cursoRequest.getIdNivel())
                .orElseThrow(() -> new ResourceNotFoundException("Nivel no encontrado"));

        CursoModel cursoModel = CursoModel.builder()
                .nombre(cursoRequest.getNombre())
                .profesor(profesor)
                .horario(horario)
                .categoria(categoria)
                .nivel(nivel)
                .build();
        cursoRepository.save(cursoModel);

        return CursoDto.builder()
                .idCurso(cursoModel.getIdCurso())
                .nombre(cursoModel.getNombre())
                .idProfesor(cursoModel.getProfesor().getDni())
                .idHorario(cursoModel.getHorario().getId())
                .idCategoria(cursoModel.getCategoria().getIdCategoria())
                .idNivel(cursoModel.getNivel().getIdNivel())
                .build();
    }

    public CursoDto getCursoById(Integer idCurso) {
        CursoModel curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        return CursoDto.builder()
                .idCurso(curso.getIdCurso())
                .nombre(curso.getNombre())
                .idProfesor(curso.getProfesor().getDni())
                .idHorario(curso.getHorario().getId())
                .idCategoria(curso.getCategoria().getIdCategoria())
                .idNivel(curso.getNivel().getIdNivel())
                .build();
    }

    public CursoDto updateCurso(Integer idCurso, CursoRequest cursoRequest) {
        CursoModel curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        PersonaModel profesor = personaRepository.findById(cursoRequest.getIdProfesor())
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado"));

        HorarioModel horario = horarioRepository.findById(cursoRequest.getIdHorario())
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado"));

        CategoriaModel categoria = categoriaRepository.findById(cursoRequest.getIdCategoria())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria no encontrada"));

        NivelModel nivel = nivelRepository.findById(cursoRequest.getIdNivel())
                .orElseThrow(() -> new ResourceNotFoundException("Nivel no encontrado"));

        curso.setNombre(cursoRequest.getNombre());
        curso.setProfesor(profesor);
        curso.setHorario(horario);
        curso.setCategoria(categoria);
        curso.setNivel(nivel);

        cursoRepository.save(curso);

        return CursoDto.builder()
                .idCurso(curso.getIdCurso())
                .nombre(curso.getNombre())
                .idProfesor(curso.getProfesor().getDni())
                .idHorario(curso.getHorario().getId())
                .idCategoria(curso.getCategoria().getIdCategoria())
                .idNivel(curso.getNivel().getIdNivel())
                .build();
    }

    public void deleteCurso(Integer idCurso) {
        CursoModel curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        cursoRepository.delete(curso);
    }

}
