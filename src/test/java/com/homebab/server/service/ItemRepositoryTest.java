package com.homebab.server.service;

import com.homebab.server.ServerApplicationTests;
import com.homebab.server.model.Item;
import com.homebab.server.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//@DataJpaTest
public class ItemRepositoryTest extends ServerApplicationTests {

    @Autowired
    ItemRepository repository;

    @Test
    void save() {
        // SELECT 있는지 체크 후 DELETE 제거
        repository.deleteAll();

        Item item = new Item();
        item.setName("감자");

        repository.save(item);

        System.out.println(item.getName());

        repository.deleteAll();
    }
}
