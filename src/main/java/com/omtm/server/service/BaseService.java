package com.omtm.server.service;

import com.omtm.server.domain.User;
import com.omtm.server.domain.UserItem;
import com.omtm.server.repository.UserItemRepository;
import com.omtm.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class BaseService {

    private final UserRepository userRepository;

    private final UserItemRepository userItemRepository;

    @Autowired
    public BaseService(UserRepository userRepository, UserItemRepository userItemRepository) {
        this.userRepository = userRepository;
        this.userItemRepository = userItemRepository;
    }


    // 사용자 식자재 추가
    public Long addUserItems(Long user_id, UserItem userItem) {
        // 사용자 조회
        User user = userRepository.findById(user_id).orElseThrow();

        // 식자재 추가
        userItem.setUser(user);

        return userItemRepository.save(userItem).getId();
    }

    // 사용자 식자재 조회
    public Set<UserItem> getUserItems(Long user_id) {
        // 사용자 조회
        User user = userRepository.findById(user_id).orElseThrow();

        return user.getUserItems();
    }
}
