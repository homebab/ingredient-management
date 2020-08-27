package com.homebab.server.service;

import com.homebab.server.domain.Item;
import com.homebab.server.domain.User;
import com.homebab.server.domain.UserItem;
import com.homebab.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // 회원가입
    public Long signUp(User user) {
        return repository.save(user).getId();
    }

    // 사용자 식자재 추가
//    public void addItems(Long id, Item item, ) {
//        // 유저 조회
//        User user = repository.findById(id).orElseThrow();
//
//        User
//    }

    // 사용자 식자재 삭제



    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public void saveAll(List<User> users) {
        repository.saveAll(users);
    }

    public void save(User user) {
        repository.saveAndFlush(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
