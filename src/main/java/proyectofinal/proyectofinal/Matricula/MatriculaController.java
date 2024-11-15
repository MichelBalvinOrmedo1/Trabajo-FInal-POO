package proyectofinal.proyectofinal.Matricula;

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
@RequestMapping("/matricula")
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<ApiResponse<MatriculaDto>> save(@RequestBody MatriculaRequest matriculaModel) {

        ApiResponse<MatriculaDto> response = new ApiResponse<>("success", "Matricula saved",
                matriculaService.save(matriculaModel));

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{idMatricula}")
    public ResponseEntity<ApiResponse<MatriculaDto>> findById(@PathVariable Integer idMatricula) {

        MatriculaDto matricula = matriculaService.findById(idMatricula);
        ApiResponse<MatriculaDto> response = new ApiResponse<>("success", "Matricula retrieved", matricula);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{idMatricula}")
    public ResponseEntity<ApiResponse<MatriculaDto>> update(@PathVariable Integer idMatricula,
            @RequestBody MatriculaRequest matriculaModel) {

        MatriculaDto updatedMatricula = matriculaService.update(idMatricula, matriculaModel);
        ApiResponse<MatriculaDto> response = new ApiResponse<>("success", "Matricula updated", updatedMatricula);

        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/{idMatricula}")
    public ApiResponse<Void> delete(@PathVariable Integer idMatricula) {
        matriculaService.deleteById(idMatricula);
        return new ApiResponse<Void>("success", "Matricula deleted", null);
    }

}
