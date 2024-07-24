package enigma.travelwise.service.impl;

import enigma.travelwise.model.UserEntity;
import enigma.travelwise.repository.UserRepository;
import enigma.travelwise.service.CloudinaryService;
import enigma.travelwise.service.UserService;
import enigma.travelwise.utils.dto.UserChangeLocationDTO;
import enigma.travelwise.utils.dto.UserChangeProfilePictureDTO;
import enigma.travelwise.utils.dto.UserDTO;
import enigma.travelwise.utils.dto.UserUpdateDTO;
import enigma.travelwise.utils.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public UserEntity update(UserUpdateDTO request, Long id) {
        UserEntity updatedUser = this.getById(id);
        updatedUser.setName(request.getName());
        updatedUser.setEmail(request.getEmail());
        updatedUser.setPassword(request.getPassword());
        updatedUser.setPhone_number(request.getPhone_number());
        // Profile Picture, Latitude Longitude tidak diganti, sama seperti yang sebelumnya
        // Karena ada fitur lain untuk mengganti profile picture dan location dari user
        updatedUser.setProfile_picture(updatedUser.getProfile_picture());
        updatedUser.setLatitude(updatedUser.getLatitude());
        updatedUser.setLongitude(updatedUser.getLongitude());
        return userRepository.save(updatedUser);
    }

    @Override
    public String changeProfilePicture(UserChangeProfilePictureDTO request, Long id) {
        UserEntity changeProfile = this.getById(id);
        changeProfile.setProfile_picture(cloudinaryService.uploadFile(request.getProfile_picture(), "travelwise_user"));
        // yang lainnya tetap sama karena sudah diprovide di fitur update
        changeProfile.setName(changeProfile.getName());
        changeProfile.setEmail(changeProfile.getEmail());
        changeProfile.setPassword(changeProfile.getPassword());
        changeProfile.setPhone_number(changeProfile.getPhone_number());
        changeProfile.setLatitude(changeProfile.getLatitude());
        changeProfile.setLongitude(changeProfile.getLongitude());
        userRepository.save(changeProfile);
        String url = changeProfile.getProfile_picture();
        String result = "New profile picture : " + url;
        return result;
    }

    @Override
    public String changeLocation(UserChangeLocationDTO request, Long id) {
        UserEntity changeLocation = this.getById(id);
        changeLocation.setLatitude(request.getLatitude());
        changeLocation.setLongitude(request.getLongitude());
        // yang lainnya tetap sama karena sudah diprovide di fitur update
        changeLocation.setName(changeLocation.getName());
        changeLocation.setEmail(changeLocation.getEmail());
        changeLocation.setPassword(changeLocation.getPassword());
        changeLocation.setPhone_number(changeLocation.getPhone_number());
        changeLocation.setProfile_picture(changeLocation.getProfile_picture());
        userRepository.save(changeLocation);
        String result = "Newest location => latitude = " + changeLocation.getLatitude() + " | longitude = " + changeLocation.getLongitude();
        return result;
    }

    @Override
    public void deleteById(Long id) {
        UserEntity deleteUser = this.getById(id);
        userRepository.delete(deleteUser);
    }
}
