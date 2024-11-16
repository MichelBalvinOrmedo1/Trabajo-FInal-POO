package proyectofinal.proyectofinal.Nota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectofinal.proyectofinal.ApiResponse.ApiResponse;

@RestController
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @PostMapping
    public ResponseEntity<ApiResponse<NotaDto>> createNota(@RequestBody NotaRequest notaRequest) {

        NotaDto notaDto = notaService.createNota(notaRequest);
        ApiResponse<NotaDto> response = new ApiResponse<>("success", "Nota created", notaDto);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{idNota}")
    public ResponseEntity<ApiResponse<NotaDto>> updateNota(@PathVariable Integer idNota,
            @RequestBody NotaRequest notaRequest) {

        NotaDto notaDto = notaService.updateNota(idNota, notaRequest);
        ApiResponse<NotaDto> response = new ApiResponse<>("success", "Nota updated", notaDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idNota}")
    public ResponseEntity<ApiResponse<NotaDto>> getNotaById(@PathVariable Integer idNota) {

        NotaDto notaDto = notaService.getNotaById(idNota);
        ApiResponse<NotaDto> response = new ApiResponse<>("success", "Nota retrieved", notaDto);

        return ResponseEntity.ok(response);
    }
}
