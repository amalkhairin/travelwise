package enigma.travelwise.service.impl;

import enigma.travelwise.model.UserEntity;
import enigma.travelwise.repository.UserRepository;
import enigma.travelwise.service.CloudinaryService;
import enigma.travelwise.service.UserService;
import enigma.travelwise.utils.dto.UserDTO;
import enigma.travelwise.utils.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity create(UserDTO request) {
        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone_number(request.getPhone_number());
        user.setProfile_picture(cloudinaryService.uploadFile(request.getProfile_picture(), "travelwise_user"));
        user.setLatitude(request.getLatitude());
        user.setLongitude(request.getLongitude());
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAll(String name) {
        Specification<UserEntity> specification = UserSpecification.getSpecification(name);
        return userRepository.findAll(specification);
    }

    @Override
    public UserEntity getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("USER WITH ID " + id + " NOT FOUND"));
    }

    @Override
    public UserEntity update(UserDTO request, Long id) {
        UserEntity updatedUser = this.getById(id);
        updatedUser.setName(request.getName());
        updatedUser.setEmail(request.getEmail());
        updatedUser.setPassword(request.getPassword());
        updatedUser.setPhone_number(request.getPhone_number());
        updatedUser.setProfile_picture(cloudinaryService.uploadFile(request.getProfile_picture(), "travelwise_user"));
        // Latitude Longitude tidak diganti, sama seperti yang sebelumnya
        updatedUser.setLatitude(updatedUser.getLatitude());
        updatedUser.setLongitude(updatedUser.getLongitude());
        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteById(Long id) {
        UserEntity deleteUser = this.getById(id);
        userRepository.delete(deleteUser);
    }
}
