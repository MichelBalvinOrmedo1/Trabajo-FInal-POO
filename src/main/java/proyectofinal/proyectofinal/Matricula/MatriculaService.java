package proyectofinal.proyectofinal.Matricula;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectofinal.proyectofinal.Grado.GradoModel;
import proyectofinal.proyectofinal.Grado.GradoRepository;
import proyectofinal.proyectofinal.Nivel.NivelModel;
import proyectofinal.proyectofinal.Nivel.NivelRepository;
import proyectofinal.proyectofinal.Persona.PersonaDto;
import proyectofinal.proyectofinal.Persona.PersonaModel;
import proyectofinal.proyectofinal.Persona.PersonaRepository;
import proyectofinal.proyectofinal.Persona.PersonaService;
import proyectofinal.proyectofinal.exception.ResourceNotFoundException;

@Service
public class MatriculaService {

        @Autowired
        private MatriculaRepository matriculaRepository;

        @Autowired
        private PersonaRepository personaRepository;

        @Autowired
        private NivelRepository nivelRepository;

        @Autowired
        private PersonaService personaService;

        @Autowired
        private GradoRepository gradoRepository;

        public MatriculaDto save(MatriculaRequest matriculaRequest) {
                PersonaModel persona = personaRepository.findById(matriculaRequest.getDniEstudiante())
                                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado"));
                NivelModel nivel = nivelRepository.findById(matriculaRequest.getIdNivel())
                                .orElseThrow(() -> new ResourceNotFoundException("Nivel no encontrado"));
                GradoModel grado = gradoRepository.findById(matriculaRequest.getIdGrado())
                                .orElseThrow(() -> new ResourceNotFoundException("Grado no encontrado"));

                MatriculaModel matricula = MatriculaModel.builder()
                                .persona(persona)
                                .nivel(nivel)
                                .grado(grado)
                                .fecha(matriculaRequest.getFecha())
                                .build();

                MatriculaModel savedMatricula = matriculaRepository.save(matricula);

                return MatriculaDto.builder()
                                .dniEstudiante(savedMatricula.getPersona().getDni())
                                .fecha(savedMatricula.getFecha())
                                .idNivel(savedMatricula.getNivel().getIdNivel())
                                .idGrado(savedMatricula.getGrado().getIdGrado())
                                .idMatricula(savedMatricula.getIdMatricula())
                                .build();
        }

        public MatriculaDto findById(Integer id) {

                MatriculaModel matricula = matriculaRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Matricula no encontrada"));

                PersonaDto estudiante = personaService.personaFindByDni(matricula.getPersona().getDni());

                return MatriculaDto.builder()
                                .dniEstudiante(matricula.getPersona().getDni())
                                .fecha(matricula.getFecha())
                                .idNivel(matricula.getNivel().getIdNivel())
                                .idGrado(matricula.getGrado().getIdGrado())
                                .estudiante(estudiante)
                                .nombreNivel(matricula.getNivel().getNombreNivel())
                                .nombreGrado(matricula.getGrado().getNombreGrado())
                                .idMatricula(matricula.getIdMatricula())
                                .build();
        }

        public void deleteById(Integer id) {

                matriculaRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Matricula no encontrada"));
                matriculaRepository.deleteById(id);
        }

        public List<MatriculaDto> findAll() {

                List<MatriculaModel> matriculas = matriculaRepository.findAll();
                List<MatriculaDto> listaMatriculas = new ArrayList<>();

                for (MatriculaModel matricula : matriculas) {
                        PersonaDto estudiante = personaService.personaFindByDni(matricula.getPersona().getDni());

                        MatriculaDto matriculaDto = MatriculaDto.builder().idMatricula(matricula.getIdMatricula())
                                        .dniEstudiante(matricula.getPersona().getDni()).fecha(matricula.getFecha())
                                        .idNivel(matricula.getNivel().getIdNivel())
                                        .estudiante(estudiante)
                                        .nombreNivel(matricula.getNivel().getNombreNivel())
                                        .nombreGrado(matricula.getGrado().getNombreGrado())
                                        .idGrado(matricula.getGrado().getIdGrado()).build();
                        listaMatriculas.add(matriculaDto);
                }

                return listaMatriculas;

        }

        public MatriculaDto update(Integer id, MatriculaRequest matriculaRequest) {
                PersonaModel persona = personaRepository.findById(matriculaRequest.getDniEstudiante())
                                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado"));
                NivelModel nivel = nivelRepository.findById(matriculaRequest.getIdNivel())
                                .orElseThrow(() -> new ResourceNotFoundException("Nivel no encontrado"));
                GradoModel grado = gradoRepository.findById(matriculaRequest.getIdGrado())
                                .orElseThrow(() -> new ResourceNotFoundException("Grado no encontrado"));

                MatriculaModel matricula = MatriculaModel.builder()
                                .persona(persona)
                                .nivel(nivel)
                                .grado(grado)
                                .fecha(matriculaRequest.getFecha())
                                .build();

                MatriculaModel updatedMatricula = matriculaRepository.save(matricula);

                PersonaDto estudiante = personaService.personaFindByDni(updatedMatricula.getPersona().getDni());

                return MatriculaDto.builder()
                                .dniEstudiante(updatedMatricula.getPersona().getDni())
                                .fecha(updatedMatricula.getFecha())
                                .idNivel(updatedMatricula.getNivel().getIdNivel())
                                .estudiante(estudiante)
                                .nombreNivel(updatedMatricula.getNivel().getNombreNivel())
                                .nombreGrado(updatedMatricula.getGrado().getNombreGrado())
                                .idGrado(updatedMatricula.getGrado().getIdGrado())
                                .idMatricula(updatedMatricula.getIdMatricula())
                                .build();
        }
}
