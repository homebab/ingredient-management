package com.homebab.server.service;

import com.homebab.server.model.Item;
import com.homebab.server.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository repository;

    @Test
    void save() {
        repository.deleteAll();
        Item item = new Item();
//        item.setId(1L);
        item.setName("감자");
        System.out.println(item.getName());
    }
}
