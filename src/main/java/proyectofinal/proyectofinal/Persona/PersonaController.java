package proyectofinal.proyectofinal.Persona;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import proyectofinal.proyectofinal.ApiResponse.ApiResponse;
import proyectofinal.proyectofinal.User.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private UserService userService;

    @GetMapping("/{tipoPersona}")
    public ApiResponse<List<PersonaDto>> getParticipatByTipoPersona(@PathVariable String tipoPersona) {
        List<PersonaDto> persona = personaService.getParticipatByTipoPersona(tipoPersona);

        return new ApiResponse<>("success", "Persona retrieved", persona);
    }

    @GetMapping("/dni/{dni}")
    public ApiResponse<PersonaDto> personaFindByDni(@PathVariable Integer dni) {
        PersonaDto persona = personaService.personaFindByDni(dni);
        System.err.println("persona: " + persona);
        return new ApiResponse<>("success", "Persona retrieved", persona);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PersonaDto>> save(@RequestBody PersonaRequest personaRequest) {

        UUID userId = userService.getAuthenticatedUserId();
        System.err.println("userId: " + userId);

        PersonaDto persona = personaService.save(personaRequest, userId);

        ApiResponse<PersonaDto> response = new ApiResponse<>("success", "Persona saved", persona);

        return ResponseEntity.ok(response);
    }

}
