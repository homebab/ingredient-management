package com.omtm.server.service;

import com.omtm.server.domain.User;
import com.omtm.server.repository.UserItemRepository;
import com.omtm.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원가입
    public Long signUp(User user) {
        return userRepository.save(user).getId();
    }

    public Optional<User> signIn(String email) {
        return userRepository.findByEmail(email);
    }

}
