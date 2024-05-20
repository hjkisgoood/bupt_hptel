package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Users;
import sjk.com.demo.repository.UsersRepository;
import sjk.com.demo.service.Enrollmentusers.RegistrationResponse;

@Service
public class Enrollmentusers {
    private final UsersRepository usersRepository;

    @Autowired
    public Enrollmentusers(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public RegistrationResponse registerUser(Users user) {
        // 在这里添加将用户数据保存到数据库的逻辑
        // 检查用户名是否已存在
        if (usersRepository.findByUsername(user.getUsername()) != null) {
            return new RegistrationResponse(false, "409", "Username already exists");
        }

        // 保存用户数据到数据库
        usersRepository.save(user);

        // 模拟用户注册成功，返回一个 RegistrationResponse 对象
        return new RegistrationResponse(true, "200", "User registered successfully");
    }

    // 内部类用于响应体
    public static class RegistrationResponse {
        private final boolean isOK;
        private final String code;
        private final String message;

        public RegistrationResponse(boolean isOK, String code, String message) {
            this.isOK = isOK;
            this.code = code;
            this.message = message;
        }

        public boolean isOK() {
            return isOK;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
