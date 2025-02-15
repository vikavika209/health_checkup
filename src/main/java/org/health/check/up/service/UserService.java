package org.health.check.up.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.health.check.up.model.User;
import org.health.check.up.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    Validator validator;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, Validator validator) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.validator = validator;
    }

    public void validateUser (User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<User> violation : violations) {
                logger.warn("{}: {}", violation.getPropertyPath(), violation.getMessage());
            }
            System.out.println("Ошибка валидации пользователя");
            throw new IllegalArgumentException("Ошибка валидации пользователя");
        }
    }

    public User createUser(String email, String password){

        String hashedPassword = passwordEncoder.encode(password);

        User user = User.builder()
                .email(email)
                .password(hashedPassword)
                .build();

        validateUser(user);

        return userRepository.save(user);
    }
}
