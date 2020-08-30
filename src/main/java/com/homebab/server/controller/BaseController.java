package com.homebab.server.controller;

import com.homebab.server.domain.Item;
import com.homebab.server.domain.User;
import com.homebab.server.service.BaseService;
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
    public Long addItem(@PathVariable Long user_id, @RequestBody Item item) { return service.addItems(user_id, item); }

    @GetMapping(value = "/get-items/{user_id}")
    public Set<Item> getItems(@PathVariable Long user_id) { return service.getItems(user_id); }
}
