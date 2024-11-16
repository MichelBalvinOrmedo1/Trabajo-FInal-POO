package proyectofinal.proyectofinal.Matricula.DetalleMatricula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectofinal.proyectofinal.Curso.CursoModel;
import proyectofinal.proyectofinal.Curso.CursoRepository;
import proyectofinal.proyectofinal.Matricula.MatriculaModel;
import proyectofinal.proyectofinal.Matricula.MatriculaRepository;
import proyectofinal.proyectofinal.exception.ResourceNotFoundException;

@Service
public class DetalleMatriculaService {

    @Autowired
    private DetalleMatriculaRepository detalleMatriculaRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public DetalleMatriculaDto save(DetalleMatriculaRequest detalleMatriculaRequest) {

        MatriculaModel matricula = matriculaRepository.findById(detalleMatriculaRequest.getIdMatricula())
                .orElseThrow(() -> new ResourceNotFoundException("Matricula no encontrada"));

        CursoModel curso = cursoRepository.findById(detalleMatriculaRequest.getIdCurso())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        DetalleMatriculaModel detalleMatricula = DetalleMatriculaModel.builder()
                .matricula(matricula)
                .curso(curso)
                .build();

        DetalleMatriculaModel savedDetalleMatricula = detalleMatriculaRepository.save(detalleMatricula);

        return DetalleMatriculaDto.builder()
                .idMatricula(savedDetalleMatricula.getMatricula().getIdMatricula())
                .idCurso(savedDetalleMatricula.getCurso().getIdCurso())
                .build();

    }

    public DetalleMatriculaDto findById(Integer idMatricula, Integer idCurso) {

        DetalleMatriculaModel detalleMatricula = detalleMatriculaRepository
                .findById(new DetalleMatriculaId(idMatricula, idCurso))
                .orElseThrow(() -> new ResourceNotFoundException("Detalle de matricula no encontrado"));

        return DetalleMatriculaDto.builder()
                .idMatricula(detalleMatricula.getMatricula().getIdMatricula())
                .idCurso(detalleMatricula.getCurso().getIdCurso())
                .build();
    }

    public void delete(Integer idMatricula, Integer idCurso) {

        MatriculaModel matricula = matriculaRepository.findById(idMatricula)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula no encontrada"));

        CursoModel curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        detalleMatriculaRepository.deleteById(new DetalleMatriculaId(matricula.getIdMatricula(), curso.getIdCurso()));
    }

}
