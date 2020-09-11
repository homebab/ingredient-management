package com.omtm.server.service;

import com.omtm.server.domain.User;
import com.omtm.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Service
@Transactional
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

    // 로그인
    public User signIn(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException(String.format("[omtm]: there is no user with email, %s", email)));
    }

    // 휴먼계정
    public void deactivate(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        user.deactivate();
    }

    // 회원탈퇴
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
