package com.omtm.server.service;

import com.omtm.server.domain.User;
import com.omtm.server.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class AuthServiceTest {

    @Autowired
    AuthService authService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void signUp() throws Exception {
//        LocalDateTime now = LocalDateTime.now();
        User user = new User("meow@gmail.com", "meow");

        Long savedId = authService.signUp(user);

        assertEquals(
                user,
                userRepository.findById(savedId).orElse(null)
        );
    }

    @Test
    public void duplicatedEmail() throws Exception {

        User user1 = new User("meow@gmail.com", "meow1");
        User user2 = new User("meow@gmail.com", "meow2");

        assertThrows(
                DataIntegrityViolationException.class,
                () -> Arrays.asList(user1, user2).forEach(u -> userRepository.save(u)),
                "Exception was expected, but passed"
        );

    }
}
