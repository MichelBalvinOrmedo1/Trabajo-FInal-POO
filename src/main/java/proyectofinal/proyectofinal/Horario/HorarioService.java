package proyectofinal.proyectofinal.Horario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectofinal.proyectofinal.exception.ResourceNotFoundException;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public HorarioDto createHorario(HorarioRequest horarioRequest) {

        HorarioModel horarioModel = HorarioModel.builder()
                .dia(horarioRequest.getDia())
                .horaInicio(horarioRequest.getHoraInicio())
                .horaFin(horarioRequest.getHoraFin())
                .build();
        horarioRepository.save(horarioModel);

        return HorarioDto.builder()
                .id(horarioModel.getId())
                .dia(horarioModel.getDia())
                .horaInicio(horarioModel.getHoraInicio())
                .horaFin(horarioModel.getHoraFin())
                .build();
    }

    public HorarioDto getHorarioById(Integer idHorario) {
        HorarioModel horario = horarioRepository.findById(idHorario)
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado"));

        return HorarioDto.builder()
                .id(horario.getId())
                .dia(horario.getDia())
                .horaInicio(horario.getHoraInicio())
                .horaFin(horario.getHoraFin())
                .build();
    }

    public void deleteHorario(Integer idHorario) {
        HorarioModel horario = horarioRepository.findById(idHorario)
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado"));

        horarioRepository.delete(horario);
    }

    public HorarioDto updateHorario(Integer idHorario, HorarioRequest horarioRequest) {
        HorarioModel horario = horarioRepository.findById(idHorario)
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado"));

        horario.setDia(horarioRequest.getDia());
        horario.setHoraInicio(horarioRequest.getHoraInicio());
        horario.setHoraFin(horarioRequest.getHoraFin());

        horarioRepository.save(horario);

        return HorarioDto.builder()
                .id(horario.getId())
                .dia(horario.getDia())
                .horaInicio(horario.getHoraInicio())
                .horaFin(horario.getHoraFin())
                .build();
    }

}
