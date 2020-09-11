package com.omtm.server.controller;

import com.omtm.server.domain.User;
import com.omtm.server.service.AuthService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    @GetMapping(value = "/users/email/{email}")
    public ResponseEntity<User> signIn(@PathVariable String email) {
//        User user = authService.signIn(email).get();
//        return new ResponseEntity<>(user, HttpStatus.OK);
        Optional<User> userOptional = authService.signIn(email);
        return userOptional
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseThrow(() -> new NoSuchElementException(String.format("[omtm]: there is no user with email, %s", email)));
    }

//    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such element") // 404
//    @ExceptionHandler(NoSuchElementException.class)
//    public void notFound() {
//        System.out.println("fuck");
//    }

}
