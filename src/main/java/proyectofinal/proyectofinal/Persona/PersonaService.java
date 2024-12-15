package proyectofinal.proyectofinal.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import proyectofinal.proyectofinal.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectofinal.proyectofinal.File.FileDTO;
import proyectofinal.proyectofinal.File.FileService;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private FileService fileService;

    public PersonaDto personaFindByDni(Integer dni) {
        PersonaModel persona = personaRepository.findByDni(dni);

        if (persona == null) {
            throw new ResourceNotFoundException("Persona no encontrada");
        }

        return PersonaDto.builder()
                .dni(persona.getDni())
                .firstName(persona.getFirstName())
                .lastName(persona.getLastName())
                .email(persona.getEmail())
                .celular(persona.getCelular())
                .tipoPersona(persona.getTipoPersona())
                .fileId(persona.getFileId())
                .personaImagen(fileService.getFilePath(persona.getFileId()))
                .build();
    }
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

    public PersonaDto save(PersonaRequest personaRequest, UUID idUser) {
        FileDTO profileImage = fileService.profileDefaul();

        UUID fileId = personaRequest.getFileId();
        if (fileId == null) {
            fileId = profileImage.getId();
        }
        PersonaModel persona = PersonaModel.builder()
                .dni(personaRequest.getDni())
                .firstName(personaRequest.getFirstName())
                .lastName(personaRequest.getLastName())
                .email(personaRequest.getEmail())
                .celular(personaRequest.getCelular())
                .tipoPersona(personaRequest.getTipoPersona())
                .fileId(fileId)
                .userId(idUser)
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
