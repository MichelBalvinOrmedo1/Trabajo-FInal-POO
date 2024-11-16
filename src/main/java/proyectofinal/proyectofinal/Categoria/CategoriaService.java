package proyectofinal.proyectofinal.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectofinal.proyectofinal.exception.ResourceNotFoundException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaDTO createCategoria(CategoriaRequest categoriaRequest) {
        CategoriaModel categoriaModel = CategoriaModel.builder()
                .nombre(categoriaRequest.getNombre())
                .build();
        categoriaRepository.save(categoriaModel);

        return CategoriaDTO.builder()
                .idCategoria(categoriaModel.getIdCategoria())
                .nombre(categoriaModel.getNombre())
                .build();
    }

    public CategoriaDTO getCategoriaById(Integer idCategoria) {
        CategoriaModel categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria no encontrada"));

        return CategoriaDTO.builder()
                .idCategoria(categoria.getIdCategoria())
                .nombre(categoria.getNombre())
                .build();
    }

    public void deleteCategoria(Integer idCategoria) {
        CategoriaModel categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria no encontrada"));

        categoriaRepository.delete(categoria);

    }

    public CategoriaDTO updateCategoria(Integer idCategoria, CategoriaRequest categoriaRequest) {
        CategoriaModel categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria no encontrada"));

        categoria.setNombre(categoriaRequest.getNombre());

        categoriaRepository.save(categoria);

        return CategoriaDTO.builder()
                .idCategoria(categoria.getIdCategoria())
                .nombre(categoria.getNombre())
                .build();
    }

}
