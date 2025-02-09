package org.health.check.up.service;

import org.health.check.up.model.User;
import org.health.check.up.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String email, String password){

        String hashedPassword = passwordEncoder.encode(password);

        User user = User.builder()
                .email(email)
                .password(hashedPassword)
                .build();

        return userRepository.save(user);
    }
}
