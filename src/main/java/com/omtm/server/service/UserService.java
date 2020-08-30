package com.omtm.server.service;

import com.omtm.server.domain.User;
import com.omtm.server.repository.UserRepository;
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
