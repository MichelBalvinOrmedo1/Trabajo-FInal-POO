package proyectofinal.proyectofinal.Persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import proyectofinal.proyectofinal.ApiResponse.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ApiResponse<List<PersonaDto>> getParticipatByTipoPersona(@RequestParam String tipoPersona) {
        List<PersonaDto> persona = personaService.getParticipatByTipoPersona(tipoPersona);

        return new ApiResponse<>("success", "Persona retrieved", persona);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PersonaDto>> save(@RequestBody PersonaRequest personaRequest) {

        PersonaDto persona = personaService.save(personaRequest);

        ApiResponse<PersonaDto> response = new ApiResponse<>("success", "Persona saved", persona);

        return ResponseEntity.ok(response);
    }

}
