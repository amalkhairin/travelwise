package enigma.travelwise.controller;

import enigma.travelwise.model.UserEntity;
import enigma.travelwise.service.UserService;
import enigma.travelwise.utils.dto.UserChangeLocationDTO;
import enigma.travelwise.utils.dto.UserChangeProfilePictureDTO;
import enigma.travelwise.utils.dto.UserDTO;
import enigma.travelwise.utils.dto.UserUpdateDTO;
import enigma.travelwise.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    private ResponseEntity<?> createUser(UserDTO request) {
        UserEntity result = userService.create(request);
        return Response.renderJSON(result, "NEW USER CREATED");
    }

    @GetMapping
    private ResponseEntity<?> getAll(@PageableDefault Pageable pageable,
                                     @RequestParam(required = false) String name) {
        return Response.renderJSON(userService.getAll(pageable, name), "SHOW ALL USERS");
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        return Response.renderJSON(userService.getById(id), "SHOW ONE USER BY ID");
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> update(@RequestBody UserUpdateDTO request,
                                     @PathVariable Long id) {
        return Response.renderJSON(userService.update(request, id), "USER UPDATED");
    }

    @PutMapping("/{id}/change-profile-picture")
    private ResponseEntity<?> changeProfile(UserChangeProfilePictureDTO request,
                                            @PathVariable Long id) {
        return Response.renderJSON(userService.changeProfilePicture(request, id), "PROFILE PICTURE CHANGED");
    }

    @PutMapping("/{id}/change-location")
    private ResponseEntity<?> changeLocation(@RequestBody UserChangeLocationDTO request,
                                             @PathVariable Long id) {
        return Response.renderJSON(userService.changeLocation(request, id), "USER LOCATION CHANGED");
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        return Response.renderJSON(userService.deleteById(id), "USER DELETED SUCCESSFULLY");
    }


}
