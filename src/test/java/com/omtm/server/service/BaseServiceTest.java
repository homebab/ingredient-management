package com.omtm.server.service;

import com.omtm.server.domain.UserItem;
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
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class BaseServiceTest {

    @Autowired
    BaseService baseService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void signUp() throws Exception {
//        LocalDateTime now = LocalDateTime.now();
        User user = new User("meow@gmail.com", "meow");

        Long savedId = baseService.signUp(user);

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

    @Test
    public void manageIngredients() throws Exception {
        User user = new User("meow@gmail.com", "meow");

        UserItem userItem1 = new UserItem("감자", "냉장");
        UserItem userItem2 = new UserItem("삼겹살", "냉동");

        List<UserItem> items = Arrays.asList(userItem1, userItem2);
        items.forEach(i -> i.setUser(user));

        Set<UserItem> userUserItems = user.getUserItems();

//        userItems.forEach(i -> System.out.println(i.getName()));
//        System.out.println(item1);
//        System.out.println(user);

        items.forEach(i -> assertTrue(userUserItems.contains(i)));
    }

}
