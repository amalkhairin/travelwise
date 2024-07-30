package enigma.travelwise.service;

import enigma.travelwise.model.UserEntity;
import enigma.travelwise.utils.dto.UserChangeLocationDTO;
import enigma.travelwise.utils.dto.UserChangeProfilePictureDTO;
import enigma.travelwise.utils.dto.UserDTO;
import enigma.travelwise.utils.dto.UserUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserEntity create(UserDTO request);
    Page<UserEntity> getAll(Pageable pageable, String name);
    UserEntity getById(Long id);
    UserEntity update(UserUpdateDTO request, Long id);
    String changeProfilePicture(UserChangeProfilePictureDTO request, Long id);
    String changeLocation(UserChangeLocationDTO request, Long id);
    String deleteById(Long id);
}
