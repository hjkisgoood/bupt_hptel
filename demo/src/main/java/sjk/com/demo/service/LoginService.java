package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Users;
import sjk.com.demo.repository.UsersRepository;

@Service
public class LoginService {

    private final UsersRepository usersRepository;

    @Autowired
    public LoginService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public String loginUser(Users user) {
        Users existingUser = usersRepository.findByUsername(user.getUsername());

        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            return "{\"message\": \"Login failed\"}";
        } else {
            return "{\"message\": \"Login successful\", \"userId\": \"" + existingUser.getUserId() +
                    "\", \"userType\": \"" + existingUser.getUserType() + "\"}";
        }
    }
}
