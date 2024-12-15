package proyectofinal.proyectofinal.aula;

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
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @PostMapping
    public ResponseEntity<ApiResponse<AulaDto>> createAula(@RequestBody AulaRequest aulaRequest) {

        AulaDto aulaDto = aulaService.createAula(aulaRequest);
        ApiResponse<AulaDto> response = new ApiResponse<>("success", "Aula created", aulaDto);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{codAula}")
    public ResponseEntity<ApiResponse<AulaDto>> updateAula(@PathVariable Integer codAula,
            @RequestBody AulaRequest aulaRequest) {

        AulaDto aulaDto = aulaService.updateAula(codAula, aulaRequest);
        ApiResponse<AulaDto> response = new ApiResponse<>("success", "Aula updated", aulaDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{codAula}")
    public ResponseEntity<ApiResponse<AulaDto>> getAula(@PathVariable Integer codAula) {

        AulaDto aulaDto = aulaService.getAula(codAula);
        ApiResponse<AulaDto> response = new ApiResponse<>("success", "Aula retrieved", aulaDto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{codAula}")
    public ResponseEntity<ApiResponse<Void>> deleteAula(@PathVariable Integer codAula) {

        aulaService.deleteAula(codAula);
        ApiResponse<Void> response = new ApiResponse<>("success", "Aula deleted", null);

        return ResponseEntity.ok(response);
    }
}
