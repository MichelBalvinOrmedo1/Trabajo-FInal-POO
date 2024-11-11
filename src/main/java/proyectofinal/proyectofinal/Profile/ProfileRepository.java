package proyectofinal.proyectofinal.Profile;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileModel, Integer> {

    ProfileModel findProfileById(Integer dni);

    ProfileModel findProfileByUserId(UUID userId);
}