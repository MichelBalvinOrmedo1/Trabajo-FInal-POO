package proyectofinal.proyectofinal.Profile;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectofinal.proyectofinal.ApiResponse.ApiResponse;
import proyectofinal.proyectofinal.User.UserService;

@RestController
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ApiResponse<ProfileDTO> getMethodName() {
        UUID userId = userService.getAuthenticatedUserId();
        ProfileDTO profile = profileService.getProfileByUserId(userId);

        return new ApiResponse<>("success", "Profile retrieved", profile);
    }

}
