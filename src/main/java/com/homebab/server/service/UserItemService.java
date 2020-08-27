package com.homebab.server.service;

import com.homebab.server.domain.Item;
import com.homebab.server.domain.User;
import com.homebab.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserItemService {

    private final ItemService itemService;

    private final UserRepository userRepository;

    @Autowired
    public UserItemService(ItemService itemService, UserRepository userRepository) {
        this.itemService = itemService;
        this.userRepository = userRepository;
    }

    public List<Item> findAllItemsById(List<Long> ids) { return itemService.findAllByIds(ids); }

    public Optional<User> findUserById(Long id) { return userRepository.findById(id); }

    public void save(User user) {
        userRepository.save(user);
    }
}