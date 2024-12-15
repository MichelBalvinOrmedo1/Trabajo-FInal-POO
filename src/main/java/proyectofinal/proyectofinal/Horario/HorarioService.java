package proyectofinal.proyectofinal.Horario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectofinal.proyectofinal.aula.AulaModel;
import proyectofinal.proyectofinal.aula.AulaRepository;
import proyectofinal.proyectofinal.exception.ResourceNotFoundException;

@Service
public class HorarioService {

        @Autowired
        private HorarioRepository horarioRepository;

        @Autowired
        private AulaRepository aulaRepository;

        public HorarioDto createHorario(HorarioRequest horarioRequest) {
                AulaModel aula = aulaRepository.findById(horarioRequest.getCodAula())
                                .orElseThrow(() -> new ResourceNotFoundException("Aula no encontrada"));

                HorarioModel horarioModel = HorarioModel.builder()
                                .dia(horarioRequest.getDia())
                                .horaInicio(horarioRequest.getHoraInicio())
                                .horaFin(horarioRequest.getHoraFin())
                                .aula(aula)
                                .build();
                horarioRepository.save(horarioModel);

                return HorarioDto.builder()
                                .id(horarioModel.getId())
                                .dia(horarioModel.getDia())
                                .horaInicio(horarioModel.getHoraInicio())
                                .horaFin(horarioModel.getHoraFin())
                                .codAula(horarioModel.getAula().getCodAula())
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
                                .codAula(horario.getAula().getCodAula())
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

                AulaModel aula = aulaRepository.findById(horarioRequest.getCodAula())
                                .orElseThrow(() -> new ResourceNotFoundException("Aula no encontrada"));

                horario.setDia(horarioRequest.getDia());
                horario.setHoraInicio(horarioRequest.getHoraInicio());
                horario.setHoraFin(horarioRequest.getHoraFin());
                horario.setAula(aula);

                horarioRepository.save(horario);

                return HorarioDto.builder()
                                .id(horario.getId())
                                .dia(horario.getDia())
                                .horaInicio(horario.getHoraInicio())
                                .horaFin(horario.getHoraFin())
                                .codAula(horario.getAula().getCodAula())
                                .build();
        }

}
