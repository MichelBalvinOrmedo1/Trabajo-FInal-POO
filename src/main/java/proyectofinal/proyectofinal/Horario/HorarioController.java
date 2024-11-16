package proyectofinal.proyectofinal.Horario;

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
@RequestMapping("/horario")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @PostMapping
    public ResponseEntity<ApiResponse<HorarioDto>> createHorario(@RequestBody HorarioRequest horarioRequest) {

        HorarioDto horarioDto = horarioService.createHorario(horarioRequest);
        ApiResponse<HorarioDto> response = new ApiResponse<>("success", "Horario created", horarioDto);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{idHorario}")
    public ResponseEntity<ApiResponse<HorarioDto>> updateHorario(@PathVariable Integer idHorario,
            @RequestBody HorarioRequest horarioRequest) {

        HorarioDto horarioDto = horarioService.updateHorario(idHorario, horarioRequest);
        ApiResponse<HorarioDto> response = new ApiResponse<>("success", "Horario updated", horarioDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idHorario}")
    public ResponseEntity<ApiResponse<HorarioDto>> getHorarioById(@PathVariable Integer idHorario) {

        HorarioDto horarioDto = horarioService.getHorarioById(idHorario);
        ApiResponse<HorarioDto> response = new ApiResponse<>("success", "Horario retrieved", horarioDto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idHorario}")
    public ResponseEntity<ApiResponse<Void>> deleteHorario(@PathVariable Integer idHorario) {

        horarioService.deleteHorario(idHorario);
        ApiResponse<Void> response = new ApiResponse<>("success", "Horario deleted", null);

        return ResponseEntity.ok(response);
    }
}
