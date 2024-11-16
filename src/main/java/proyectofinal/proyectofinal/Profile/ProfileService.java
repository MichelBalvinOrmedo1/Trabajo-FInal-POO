package proyectofinal.proyectofinal.Profile;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectofinal.proyectofinal.File.FileDTO;
import proyectofinal.proyectofinal.File.FileService;
import proyectofinal.proyectofinal.exception.ProfileNotFoundException;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private FileService fileService;

    public ProfileDTO getProfileByUserId(UUID userId) {
        ProfileModel profileModel = profileRepository.findProfileByUserId(userId);

        if (profileModel == null) {
            throw new ProfileNotFoundException("Profile not found");
        }

        String profileImage = fileService.getFilePath(profileModel.getFileId());

        return new ProfileDTO.ProfileDTOBuilder().firstName(profileModel.getFirstName())
                .lastName(profileModel.getLastName()).email(profileModel.getEmail()).fileId(profileModel.getFileId())
                .profileImage(profileImage).dni(profileModel.getDni()).build();

    }

    public ProfileDTO getProfileById(Integer dni) {
        ProfileModel profileModel = profileRepository.findProfileByDni(dni);

        if (profileModel == null) {
            throw new ProfileNotFoundException("Profile not found ");
        }
        String profileImage = fileService.getFilePath(profileModel.getFileId());

        return new ProfileDTO.ProfileDTOBuilder().firstName(profileModel.getFirstName())
                .lastName(profileModel.getLastName()).email(profileModel.getEmail()).fileId(profileModel.getFileId())
                .profileImage(profileImage).dni(profileModel.getDni()).build();
    }

    public ProfileDTO createProfile(ProfileRequest profileRequest, UUID userId) {

        ProfileModel profileModel = ProfileModel.builder()
                .dni(profileRequest.getDni())
                .firstName(profileRequest.getFirstName())
                .lastName(profileRequest.getLastName())
                .email(profileRequest.getEmail())
                .userId(userId)
                .fileId(null)
                .build();

        ProfileModel savedProfile = profileRepository.save(profileModel);

        // profile for default image
        FileDTO profileImage = fileService.profileDefaul();
        String profileDefaul = "src\\\\main\\\\resources\\\\static\\\\image\\\\profile\\\\perfilPreDeter.jpg";
        savedProfile.setFileId(profileImage.getId());
        profileRepository.save(savedProfile);

        return new ProfileDTO.ProfileDTOBuilder().firstName(savedProfile.getFirstName())
                .lastName(savedProfile.getLastName()).email(savedProfile.getEmail()).fileId(savedProfile.getFileId())
                .profileImage(profileDefaul).dni(savedProfile.getDni()).build();
    }

}
