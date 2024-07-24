package enigma.travelwise.service;

import enigma.travelwise.model.UserEntity;
import enigma.travelwise.utils.dto.UserChangeLocationDTO;
import enigma.travelwise.utils.dto.UserChangeProfilePictureDTO;
import enigma.travelwise.utils.dto.UserDTO;
import enigma.travelwise.utils.dto.UserUpdateDTO;
import java.util.List;

public interface UserService {
    UserEntity create(UserDTO request);
    List<UserEntity> getAll(String name);
    UserEntity getById(Long id);
    UserEntity update(UserUpdateDTO request, Long id);
    String changeProfilePicture(UserChangeProfilePictureDTO request, Long id);
    String changeLocation(UserChangeLocationDTO request, Long id);
    void deleteById(Long id);
}
