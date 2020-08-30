package com.omtm.server.service;

import com.omtm.server.domain.Item;
import com.omtm.server.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository repository;

    @Autowired
    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> findAll() {
        return repository.findAll();
    }

    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

//    public List<Item> findAllByIds(List<Long> itemIds) {
//        return repository.findAllById(itemIds);
//    }

    public void saveAll(List<Item> items) {
        repository.saveAll(items);
    }

    public void save(Item item) {
        repository.saveAndFlush(item);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
