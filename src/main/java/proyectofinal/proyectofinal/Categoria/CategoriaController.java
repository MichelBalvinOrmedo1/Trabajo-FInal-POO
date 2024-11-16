package proyectofinal.proyectofinal.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectofinal.proyectofinal.ApiResponse.ApiResponse;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<ApiResponse<CategoriaDTO>> createCategoria(@RequestBody CategoriaRequest categoriaRequest) {

        CategoriaDTO categoriaDto = categoriaService.createCategoria(categoriaRequest);
        ApiResponse<CategoriaDTO> response = new ApiResponse<>("success", "Categoria created", categoriaDto);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{idCategoria}")
    public ResponseEntity<ApiResponse<CategoriaDTO>> updateCategoria(@PathVariable Integer idCategoria,
            @RequestBody CategoriaRequest categoriaRequest) {

        CategoriaDTO categoriaDto = categoriaService.updateCategoria(idCategoria, categoriaRequest);
        ApiResponse<CategoriaDTO> response = new ApiResponse<>("success", "Categoria updated", categoriaDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<ApiResponse<CategoriaDTO>> getCategoriaById(@PathVariable Integer idCategoria) {

        CategoriaDTO categoriaDto = categoriaService.getCategoriaById(idCategoria);
        ApiResponse<CategoriaDTO> response = new ApiResponse<>("success", "Categoria retrieved", categoriaDto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<ApiResponse<Void>> deleteCategoria(@PathVariable Integer idCategoria) {

        categoriaService.deleteCategoria(idCategoria);
        ApiResponse<Void> response = new ApiResponse<>("success", "Categoria deleted", null);

        return ResponseEntity.ok(response);
    }
}
