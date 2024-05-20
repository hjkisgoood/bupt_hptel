package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Users;
import sjk.com.demo.repository.UsersRepository;

@Service
public class Enrollmentusers {

    private final UsersRepository usersRepository;

    @Autowired
    public Enrollmentusers(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public String registerUser(Users user) {
        // 在这里编写用户注册逻辑，例如保存用户到数据库等
        Users savedUser = usersRepository.save(user);

        // 返回注册成功后的用户 ID
        return String.valueOf(savedUser.getUserId());
    }
}

