package com.omtm.server.controller;

import com.omtm.server.domain.UserItem;
import com.omtm.server.dto.UserItemDto;
import com.omtm.server.service.BaseService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@Api(value = "base", tags = "Ingredients Management")
@RestController
@RequestMapping("/api")
public class BaseController {

    private final BaseService service;

    public BaseController(BaseService service) {
        this.service = service;
    }

    @PostMapping(value = "/items/{userId}")
    public Long addUserItem(@PathVariable Long userId, @RequestBody @Valid UserItem userItem) {
        return service.addUserItems(userId, userItem);
    }

    @GetMapping(value = "/items/{userId}")
    public Set<UserItemDto.Response> getUserItems(@PathVariable Long userId) {
        return service.getUserItems(userId).stream().map(UserItemDto.Response::new).collect(Collectors.toSet());
    }

    @DeleteMapping(value = "/items/{userItemId}")
    public Long deleteUserItem(@PathVariable Long userItemId) {
        service.deleteUserItems(userItemId);
        return userItemId;
    }
}
