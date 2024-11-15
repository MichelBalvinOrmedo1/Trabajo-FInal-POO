package proyectofinal.proyectofinal.Grado;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectofinal.proyectofinal.exception.ResourceNotFoundException;

@Service
public class GradoService {

    @Autowired
    private GradoRepository gradoRepository;

    public GradoDto save(GradoRequest gradoModel) {

        GradoModel grado = GradoModel.builder()
                .nombreGrado(gradoModel.getNombreGrado())
                .build();

        GradoModel savedGrado = gradoRepository.save(grado);

        return GradoDto.builder()
                .idGrado(savedGrado.getIdGrado())
                .nombreGrado(savedGrado.getNombreGrado())
                .build();
    }

    public GradoDto findById(Integer idGrado) {

        GradoModel gradoModel = gradoRepository.findById(idGrado)
                .orElseThrow(() -> new ResourceNotFoundException(" Grado not found"));

        return GradoDto.builder()
                .idGrado(gradoModel.getIdGrado())
                .nombreGrado(gradoModel.getNombreGrado())
                .build();
    }

    public List<GradoDto> findAll() {

        List<GradoModel> gradoModelList = gradoRepository.findAll();

        List<GradoDto> gradoDtoList = new ArrayList<>();

        for (GradoModel gradoModel : gradoModelList) {
            GradoDto gradoDto = GradoDto.builder()
                    .idGrado(gradoModel.getIdGrado())
                    .nombreGrado(gradoModel.getNombreGrado())
                    .build();

            gradoDtoList.add(gradoDto);
        }

        return gradoDtoList;

    }

    public void deleteById(Integer idGrado) {
        gradoRepository.findById(idGrado)
                .orElseThrow(() -> new ResourceNotFoundException(" Grado not found"));
        // Si el grado no existe, retornar

        gradoRepository.deleteById(idGrado);
    }

    public GradoDto update(Integer idGrado, GradoRequest gradoRequest) {

        GradoModel gradoModel = gradoRepository.findById(idGrado)
                .orElseThrow(() -> new ResourceNotFoundException(" Grado not found"));

        gradoModel.setNombreGrado(gradoRequest.getNombreGrado());

        GradoModel updatedGrado = gradoRepository.save(gradoModel);

        return GradoDto.builder()
                .idGrado(updatedGrado.getIdGrado())
                .nombreGrado(updatedGrado.getNombreGrado())
                .build();
    }

}
