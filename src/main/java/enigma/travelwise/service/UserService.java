package enigma.travelwise.service;

import enigma.travelwise.model.UserEntity;
import enigma.travelwise.utils.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserEntity create(UserDTO request);
    List<UserEntity> getAll(String name);
    UserEntity getById(Long id);
    UserEntity update(UserDTO request, Long id);
    void deleteById(Long id);
}
