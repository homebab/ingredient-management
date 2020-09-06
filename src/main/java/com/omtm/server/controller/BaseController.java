package com.omtm.server.controller;

import com.omtm.server.domain.UserItem;
import com.omtm.server.domain.User;
import com.omtm.server.service.BaseService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class BaseController {

    private final BaseService service;

    public BaseController(BaseService service) { this.service = service; }

    @PostMapping(value = "/users")
    public Long signIn(@RequestBody @Valid User user) { return service.signUp(user); }

    @PostMapping(value = "/items/{user_id}")
    public Long addItem(@PathVariable Long user_id, @RequestBody @Valid UserItem userItem) { return service.addUserItems(user_id, userItem); }

    @GetMapping(value = "/items/{user_id}")
    public Set<UserItem> getItems(@PathVariable Long user_id) { return service.getUserItems(user_id); }
}
