package enigma.travelwise.security;

import enigma.travelwise.model.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class UserSecurity {

    public boolean hasUserId(Authentication authentication, Integer userId) {
        Integer currentUserId = (Integer) authentication.getDetails();
        return currentUserId.equals(userId);
    }

    // Check if authenticated user has the specified user ID
    public boolean isUser(Authentication authentication, int userId) {
        // If the authentication object is null or not authenticated yet, return false
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }
        // Get the principal from authenticated user
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserEntity)) { // If the principal not instance of the User class, return false
            return false;
        }
        // Compare the authenticated user ID by casting the principal to a User Object with stored User ID
        UserEntity user = (UserEntity) principal;
        return user.getId() == userId;
    }
}
