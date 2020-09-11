package com.omtm.server.service;

import com.omtm.server.domain.Item;
import com.omtm.server.domain.User;
import com.omtm.server.domain.UserItem;
import com.omtm.server.repository.ItemRepository;
import com.omtm.server.repository.UserItemRepository;
import com.omtm.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class BaseService {

    private final UserRepository userRepository;

    private final UserItemRepository userItemRepository;

    private final ItemRepository itemRepository;

    @Autowired
    public BaseService(UserRepository userRepository, UserItemRepository userItemRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.userItemRepository = userItemRepository;
        this.itemRepository = itemRepository;
    }


    // 사용자 식자재 추가
    public Long addUserItems(Long user_id, UserItem userItem) {
        // 사용자 조회
        User user = userRepository.findById(user_id).orElseThrow();
        // 식자재 사전 조회
        Optional<Item> item = itemRepository.findByName(userItem.getName()) ;

        // 식자재 추가
        userItem.setUser(user);
        item.ifPresent(userItem::setItem);

        // 식자재 저장
        return userItemRepository.save(userItem).getId();
    }

    // 사용자 식자재 조회
    public Set<UserItem> getUserItems(Long user_id) {
        // 사용자 조회
        User user = userRepository.findById(user_id).orElseThrow();

        return user.getUserItems();
    }

    // 사용자 식자재 삭제
    public void deleteUserItems(Long userItemId) {
        userItemRepository.deleteById(userItemId);
    }
}
