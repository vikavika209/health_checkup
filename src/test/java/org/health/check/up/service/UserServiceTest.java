package org.health.check.up.service;

import org.health.check.up.model.User;
import org.health.check.up.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;

class UserServiceTest {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    UserService userService;

    @BeforeEach
    void beforeEach() {
        userRepository = Mockito.mock(UserRepository.class);
        passwordEncoder = new BCryptPasswordEncoder();
        userService = new UserService(userRepository, passwordEncoder);
    }

    @Test
    void createUser() {

        String username = "test";
        String password = "test";

        User user = User.builder()
                        .email(username)
                        .password(passwordEncoder.encode(password))
                                        .build();

        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(username, password);

        Assertions.assertNotNull(createdUser);
        Assertions.assertEquals(username, createdUser.getEmail());

        verify(userRepository, times(1)).save(Mockito.any(User.class));

    }
}