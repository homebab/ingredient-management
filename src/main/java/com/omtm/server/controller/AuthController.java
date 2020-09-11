package com.omtm.server.controller;

import com.omtm.server.domain.User;
import com.omtm.server.service.AuthService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "auth", tags = "User Management")
@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<Long> signUp(@RequestBody @Valid User user) {
        Long id = authService.signUp(user);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<User> signIn(@RequestParam String email) {
        User user = authService.signIn(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<Long> deactivate(@PathVariable Long id) {
        authService.deactivate(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        authService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
