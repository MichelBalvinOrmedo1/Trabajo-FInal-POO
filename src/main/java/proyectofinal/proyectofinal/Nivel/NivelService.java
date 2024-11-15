package proyectofinal.proyectofinal.Nivel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectofinal.proyectofinal.exception.ResourceNotFoundException;

@Service
public class NivelService {

        @Autowired
        private NivelRepository nivelRepository;

        public NivelDto getNivelById(Integer idNivel) {
                NivelModel nivel = nivelRepository.findById(idNivel)
                                .orElseThrow(() -> new ResourceNotFoundException(" Nivel not found"));

                return NivelDto.builder()
                                .idNivel(nivel.getIdNivel())
                                .nombreNivel(nivel.getNombreNivel())
                                .build();
        }

        public NivelDto saveNivel(NivelRequest nivel) {

                NivelModel nivelModel = NivelModel.builder()
                                .nombreNivel(nivel.getNombreNivel())
                                .build();

                NivelModel savedNivel = nivelRepository.save(nivelModel);

                return NivelDto.builder()
                                .idNivel(savedNivel.getIdNivel())
                                .nombreNivel(savedNivel.getNombreNivel())
                                .build();
        }

        public void deleteNivel(Integer idNivel) {
                nivelRepository.findById(idNivel)
                                .orElseThrow(() -> new ResourceNotFoundException(" Nivel not found"));

                nivelRepository.deleteById(idNivel);
        }

        public NivelDto updateNivel(Integer idNivel, NivelRequest nivel) {

                nivelRepository.findById(idNivel)
                                .orElseThrow(() -> new ResourceNotFoundException(" Nivel not found"));

                NivelModel nivelModel = NivelModel.builder()
                                .idNivel(idNivel)
                                .nombreNivel(nivel.getNombreNivel())
                                .build();

                NivelModel updatedNivel = nivelRepository.save(nivelModel);

                return NivelDto.builder()
                                .idNivel(updatedNivel.getIdNivel())
                                .nombreNivel(updatedNivel.getNombreNivel())
                                .build();
        }

        public List<NivelDto> getAllNiveles() {

                List<NivelModel> niveles = nivelRepository.findAll();

                List<NivelDto> nivelList = new ArrayList<>();

                for (NivelModel nivel : niveles) {
                        NivelDto nivelDto = NivelDto.builder()
                                        .idNivel(nivel.getIdNivel())
                                        .nombreNivel(nivel.getNombreNivel())
                                        .build();

                        nivelList.add(nivelDto);
                }

                return nivelList;

        }
}
