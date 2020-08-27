package com.homebab.server.service;

import com.homebab.server.domain.User;
import com.homebab.server.repository.UserRepository;
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
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void signUp() throws Exception {
//        LocalDateTime now = LocalDateTime.now();
        User user = new User();
        user.setName("meow");
        user.setEmail("meow@gmail.com");

        Long savedId = userService.signUp(user);

        assertEquals(
                user,
                userRepository.findById(savedId).orElse(null)
        );
    }

    @Test
    public void duplicatedEmail() throws Exception {

        User user1 = new User();
        user1.setName("meow1");
        user1.setEmail("meow@gmail.com");
        User user2 = new User();
        user2.setName("meow2");
        user2.setEmail("meow@gmail.com");

        assertThrows(
                DataIntegrityViolationException.class,
                () -> Arrays.asList(user1, user2).forEach(u -> userRepository.save(u)),
                "Exception was expected, but passed"
        );

    }


}
