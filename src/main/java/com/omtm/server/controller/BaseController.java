package com.omtm.server.controller;

import com.omtm.server.domain.UserItem;
import com.omtm.server.service.BaseService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Api(value = "base", tags = "Ingredients Management")
@RestController
@RequestMapping("/api")
public class BaseController {

    private final BaseService service;

    public BaseController(BaseService service) {
        this.service = service;
    }

    @PostMapping(value = "/items/{user_id}")
    public Long addItem(@PathVariable Long user_id, @RequestBody @Valid UserItem userItem) {
        return service.addUserItems(user_id, userItem);
    }

    @GetMapping(value = "/items/{user_id}")
    public Set<UserItem> getItems(@PathVariable Long user_id) {
        return service.getUserItems(user_id);
    }
}
