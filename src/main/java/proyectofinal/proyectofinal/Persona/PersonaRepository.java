package proyectofinal.proyectofinal.Persona;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaModel, Integer> {
    // Obtener persona por tipoPersona es una lista
    List<PersonaModel> findByTipoPersona(String tipoPersona);
}
