package org.health.check.up.service;

import jakarta.validation.Validator;
import org.health.check.up.model.User;
import org.health.check.up.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private Validator validator;

    @InjectMocks
    private UserService userService;


    @Test
    void createUser() {

        String username = "test";
        String password = "test";
        String encodedPassword = "hashedPassword";

        User user = User.builder()
                        .email(username)
                        .password(passwordEncoder.encode(password))
                                        .build();


        when(validator.validate(any(User.class))).thenReturn(Collections.emptySet());
        when(passwordEncoder.encode(any(String.class))).thenReturn(encodedPassword);
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(username, password);

        Assertions.assertNotNull(createdUser);
        Assertions.assertEquals(username, createdUser.getEmail());

        verify(userRepository, times(1)).save(Mockito.any(User.class));

    }
}