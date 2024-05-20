package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Users;
import sjk.com.demo.service.Enrollmentusers;
import sjk.com.demo.service.Enrollmentusers.RegistrationResponse;

@RestController
public class Enroll {
    private final Enrollmentusers enrollmentusers;

    @Autowired
    public Enroll(Enrollmentusers enrollmentusers) {
        this.enrollmentusers = enrollmentusers;
    }

    @PostMapping("/api/user/register")
    public RegistrationResponse registerUser(@RequestBody Users user) {
        return enrollmentusers.registerUser(user);
    }
}
