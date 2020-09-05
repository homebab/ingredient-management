package com.omtm.server.controller;

import com.omtm.server.domain.UserItem;
import com.omtm.server.domain.User;
import com.omtm.server.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/base")
public class BaseController {

    private final BaseService service;

    public BaseController(BaseService service) { this.service = service; }

    @PostMapping(value = "/sign-in")
    public Long signIn(@RequestBody User user) { return service.signUp(user); }

    @PostMapping(value = "/add-item/{user_id}")
    public Long addItem(@PathVariable Long user_id, @RequestBody UserItem userItem) { return service.addUserItems(user_id, userItem); }

    @GetMapping(value = "/get-items/{user_id}")
    public Set<UserItem> getItems(@PathVariable Long user_id) { return service.getUserItems(user_id); }
}
