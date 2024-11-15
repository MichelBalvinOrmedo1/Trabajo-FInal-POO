package proyectofinal.proyectofinal.Nivel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("nivel")
public class NivelController {

    @Autowired
    private NivelService nivelService;

    @GetMapping
    public ResponseEntity<ApiResponse<Iterable<NivelDto>>> getAllNiveles() {
        Iterable<NivelDto> niveles = nivelService.getAllNiveles();

        ApiResponse<Iterable<NivelDto>> response = new ApiResponse<>("success", "Niveles retrieved", niveles);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<NivelDto>> saveNivel(@Valid @RequestBody NivelRequest nivelDto) {

        NivelDto savedNivel = nivelService.saveNivel(nivelDto);

        ApiResponse<NivelDto> response = new ApiResponse<>("success", "Nivel saved", savedNivel);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PutMapping("/{idNivel}")
    public ResponseEntity<ApiResponse<NivelDto>> updateNivel(@PathVariable Integer idNivel,
            @Valid @RequestBody NivelRequest nivelDto) {

        NivelDto updatedNivel = nivelService.updateNivel(idNivel, nivelDto);

        ApiResponse<NivelDto> response = new ApiResponse<>("success", "Nivel updated", updatedNivel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{idNivel}")
    public ResponseEntity<ApiResponse<NivelDto>> deleteNivel(@PathVariable Integer idNivel) {
        nivelService.deleteNivel(idNivel);

        ApiResponse<NivelDto> response = new ApiResponse<>("success", "Nivel deleted", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{idNivel}")
    public ResponseEntity<ApiResponse<NivelDto>> getNivelById(@PathVariable Integer idNivel) {
        NivelDto nivel = nivelService.getNivelById(idNivel);

        ApiResponse<NivelDto> response = new ApiResponse<>("success", "Nivel retrieved", nivel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
