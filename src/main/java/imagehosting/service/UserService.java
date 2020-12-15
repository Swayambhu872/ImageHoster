package imagehosting.service;

import imagehosting.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void registerUser(User newUser) {
        return;
    }


        public boolean login(User user) {
            if(user.getUsername().equals("validuser")) {
                return true;
            }
            else {
                return false;
            }
        }
}

