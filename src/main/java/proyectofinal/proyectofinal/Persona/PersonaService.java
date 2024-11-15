package proyectofinal.proyectofinal.Persona;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectofinal.proyectofinal.File.FileService;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private FileService fileService;

    public List<PersonaDto> getParticipatByTipoPersona(String tipoPersona) {
        List<PersonaModel> personas = personaRepository.findByTipoPersona(tipoPersona);
        List<PersonaDto> personaList = new ArrayList<>();
        for (PersonaModel persona : personas) {
            String personaImagen = fileService.getFilePath(persona.getFileId());
            PersonaDto personaDto = PersonaDto.builder()
                    .dni(persona.getDni())
                    .firstName(persona.getFirstName())
                    .lastName(persona.getLastName())
                    .email(persona.getEmail())
                    .celular(persona.getCelular())
                    .tipoPersona(persona.getTipoPersona())
                    .fileId(persona.getFileId())
                    .personaImagen(personaImagen)
                    .build();

            personaList.add(personaDto);

        }

        return personaList;
    }

    public PersonaDto save(PersonaRequest personaRequest) {
        PersonaModel persona = PersonaModel.builder()
                .dni(personaRequest.getDni())
                .firstName(personaRequest.getFirstName())
                .lastName(personaRequest.getLastName())
                .email(personaRequest.getEmail())
                .celular(personaRequest.getCelular())
                .tipoPersona(personaRequest.getTipoPersona())
                .fileId(personaRequest.getFileId())
                .build();

        PersonaModel savedPersona = personaRepository.save(persona);

        return PersonaDto.builder()
                .dni(savedPersona.getDni())
                .firstName(savedPersona.getFirstName())
                .lastName(savedPersona.getLastName())
                .email(savedPersona.getEmail())
                .celular(savedPersona.getCelular())
                .tipoPersona(savedPersona.getTipoPersona())
                .fileId(savedPersona.getFileId())
                .build();
    }
}
