package proyectofinal.proyectofinal.Grado;

import java.util.List;

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

import jakarta.validation.Valid;
import proyectofinal.proyectofinal.ApiResponse.ApiResponse;

@RestController
@RequestMapping("/grado")
public class GradoController {

    @Autowired
    private GradoService gradoService;

    @PostMapping
    public ResponseEntity<ApiResponse<GradoDto>> save(@Valid @RequestBody GradoRequest gradoRequest) {

        ApiResponse<GradoDto> response = new ApiResponse<>("success", "Grado saved", gradoService.save(gradoRequest));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idGrado}")
    public ResponseEntity<ApiResponse<GradoDto>> findById(@PathVariable Integer idGrado) {

        GradoDto grado = gradoService.findById(idGrado);
        ApiResponse<GradoDto> response = new ApiResponse<>("success", "Grado retrieved", grado);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GradoDto>>> findAll() {

        List<GradoDto> gradoList = gradoService.findAll();
        ApiResponse<List<GradoDto>> response = new ApiResponse<>("success", "Grado retrieved", gradoList);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idGrado}")
    public void deleteById(@PathVariable Integer idGrado) {
        gradoService.deleteById(idGrado);
    }

    @PutMapping("/{idGrado}")
    public ResponseEntity<ApiResponse<GradoDto>> update(@PathVariable Integer idGrado,
            @RequestBody GradoRequest gradoRequest) {

        GradoDto updatedGrado = gradoService.update(idGrado, gradoRequest);
        ApiResponse<GradoDto> response = new ApiResponse<>("success", "Grado updated", updatedGrado);

        return ResponseEntity.ok(response);
    }

}
