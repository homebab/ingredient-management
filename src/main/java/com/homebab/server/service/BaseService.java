package com.homebab.server.service;

import com.homebab.server.domain.Item;
import com.homebab.server.domain.User;
import com.homebab.server.repository.ItemRepository;
import com.homebab.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class BaseService {

    private final UserRepository userRepository;

    private final ItemRepository itemRepository;

    @Autowired
    public BaseService(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }


    // 회원가입
    public Long signUp(User user) {
        return userRepository.save(user).getId();
    }


    // 사용자 식자재 추가
    public Long addItems(Long user_id, Item item) {
        // 사용자 조회
        User user = userRepository.findById(user_id).orElseThrow();

        // 식자재 추가
        item.setUser(user);

        return itemRepository.save(item).getId();
    }

    // 사용자 식자재 조회
    public Set<Item> getItems(Long user_id) {
        // 사용자 조회
        User user = userRepository.findById(user_id).orElseThrow();

        return user.getItems();
    }
}
