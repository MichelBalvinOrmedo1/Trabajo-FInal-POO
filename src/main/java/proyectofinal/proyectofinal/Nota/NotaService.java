package proyectofinal.proyectofinal.Nota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectofinal.proyectofinal.Curso.CursoModel;
import proyectofinal.proyectofinal.Curso.CursoRepository;
import proyectofinal.proyectofinal.Matricula.MatriculaModel;
import proyectofinal.proyectofinal.Matricula.MatriculaRepository;
import proyectofinal.proyectofinal.exception.ResourceNotFoundException;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public NotaDto createNota(NotaRequest notaRequest) {

        MatriculaModel matricula = matriculaRepository.findById(notaRequest.getIdMatricula())
                .orElseThrow(() -> new ResourceNotFoundException("Matricula no encontrada"));

        CursoModel curso = cursoRepository.findById(notaRequest.getIdCurso())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        NotaModel notaModel = NotaModel.builder()
                .matricula(matricula)
                .curso(curso)
                .nota(notaRequest.getNota())
                .fecha(notaRequest.getFechaNota())
                .build();
        notaRepository.save(notaModel);

        return NotaDto.builder()
                .idNota(notaModel.getIdNota())
                .idMatricula(notaModel.getMatricula().getIdMatricula())
                .idCurso(notaModel.getCurso().getIdCurso())
                .nota(notaModel.getNota())
                .fechaNota(notaModel.getFecha())
                .build();
    }

    public NotaDto getNotaById(Integer idNota) {
        NotaModel nota = notaRepository.findById(idNota)
                .orElseThrow(() -> new ResourceNotFoundException("Nota no encontrada"));

        return NotaDto.builder()
                .idNota(nota.getIdNota())
                .idMatricula(nota.getMatricula().getIdMatricula())
                .idCurso(nota.getCurso().getIdCurso())
                .nota(nota.getNota())
                .fechaNota(nota.getFecha())
                .build();
    }

    public NotaDto updateNota(Integer idNota, NotaRequest notaRequest) {
        NotaModel nota = notaRepository.findById(idNota)
                .orElseThrow(() -> new ResourceNotFoundException("Nota no encontrada"));

        MatriculaModel matricula = matriculaRepository.findById(notaRequest.getIdMatricula())
                .orElseThrow(() -> new ResourceNotFoundException("Matricula no encontrada"));

        CursoModel curso = cursoRepository.findById(notaRequest.getIdCurso())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        nota.setMatricula(matricula);
        nota.setCurso(curso);
        nota.setNota(notaRequest.getNota());
        nota.setFecha(notaRequest.getFechaNota());

        notaRepository.save(nota);

        return NotaDto.builder()
                .idNota(nota.getIdNota())
                .idMatricula(nota.getMatricula().getIdMatricula())
                .idCurso(nota.getCurso().getIdCurso())
                .nota(nota.getNota())
                .fechaNota(nota.getFecha())
                .build();
    }

    public void deleteNota(Integer idNota) {
        NotaModel nota = notaRepository.findById(idNota)
                .orElseThrow(() -> new ResourceNotFoundException("Nota no encontrada"));

        notaRepository.delete(nota);
    }
}
