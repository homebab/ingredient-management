package com.homebab.server.service;

import com.homebab.server.domain.Item;
import com.homebab.server.domain.User;
import com.homebab.server.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    public void manageIngredients() throws Exception {
        User user = new User();
        user.setName("meow");
        user.setEmail("meow@gmail.com");

        Item item1 = new Item();
        item1.setName("감자");
        item1.setExpiredAt(LocalDateTime.of(2020, 9, 10, 0, 0));
        item1.setCategory("야채");
        Item item2 = new Item();
        item2.setName("삼겹살");
        item2.setExpiredAt(LocalDateTime.of(2020, 9, 3, 0, 0));
        item2.setCategory("육류");

        List<Item> items = Arrays.asList(item1, item2);
        items.forEach(user::addItem);

        Set<Item> userItems = user.getItems();

//        System.out.println(item1);
//        System.out.println(user);

        items.forEach(i -> System.out.println(userItems.contains(i)));
    }

}
