package proyectofinal.proyectofinal.aula;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectofinal.proyectofinal.exception.ResourceNotFoundException;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    public AulaDto createAula(AulaRequest aulaRequest) {
        String estado = aulaRequest.getEstado();
        if (estado == null) {
            estado = "Disponible"; // Valor por defecto
        }

        AulaModel aulaModel = AulaModel.builder()
                .cantActual(aulaRequest.getCantActual())
                .cantMaxima(aulaRequest.getCantMaxima())
                .estado(estado)
                .build();
        aulaModel = aulaRepository.save(aulaModel);
        return AulaDto.builder()
                .codAula(aulaModel.getCodAula())
                .cantActual(aulaModel.getCantActual())
                .cantMaxima(aulaModel.getCantMaxima())
                .estado(aulaModel.getEstado())
                .build();
    }

    public AulaDto getAula(Integer codAula) {
        AulaModel aulaModel = aulaRepository.findById(codAula)
                .orElseThrow(() -> new ResourceNotFoundException("Aula no encontrado"));

        return AulaDto.builder()
                .codAula(aulaModel.getCodAula())
                .cantActual(aulaModel.getCantActual())
                .cantMaxima(aulaModel.getCantMaxima())
                .estado(aulaModel.getEstado())
                .build();
    }

    public List<AulaDto> findAll() {
        return aulaRepository.findAll().stream()
                .map(aula -> AulaDto.builder()
                        .codAula(aula.getCodAula())
                        .cantActual(aula.getCantActual())
                        .cantMaxima(aula.getCantMaxima())
                        .estado(aula.getEstado())
                        .build())
                .collect(Collectors.toList());
    }

    public AulaDto updateAula(Integer codAula, AulaRequest aulaRequest) {
        AulaModel aulaModel = aulaRepository.findById(codAula)
                .orElseThrow(() -> new ResourceNotFoundException("Aula no encontrado"));

        String estado = aulaRequest.getEstado();
        if (estado == null) {
            estado = "Disponible"; // Valor por defecto
        }

        aulaModel.setCantActual(aulaRequest.getCantActual());
        aulaModel.setCantMaxima(aulaRequest.getCantMaxima());
        aulaModel.setEstado(estado);
        aulaModel = aulaRepository.save(aulaModel);
        return AulaDto.builder()
                .codAula(aulaModel.getCodAula())
                .cantActual(aulaModel.getCantActual())
                .cantMaxima(aulaModel.getCantMaxima())
                .estado(aulaModel.getEstado())
                .build();
    }

    public void deleteAula(Integer codAula) {
        aulaRepository.findById(codAula)
                .orElseThrow(() -> new ResourceNotFoundException("Aula no encontrado"));
        aulaRepository.deleteById(codAula);
    }
}
