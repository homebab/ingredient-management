package com.omtm.server.controller;

import com.omtm.server.domain.UserItem;
import com.omtm.server.domain.User;
import com.omtm.server.service.BaseService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class BaseController {

    private final BaseService service;

    public BaseController(BaseService service) { this.service = service; }

    @GetMapping(value = "/address")
    public String getAddress() {
        String hostName, ipAddress;

        try {
            hostName = InetAddress.getLocalHost().getHostName();
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            hostName = "Error : " + e.getLocalizedMessage();
            ipAddress = "";
        }

        return String.format("hostName: %s, ipAddress: %s", hostName, ipAddress);
    }

    @PostMapping(value = "/users")
    public Long signIn(@RequestBody @Valid User user) { return service.signUp(user); }

    @PostMapping(value = "/items/{user_id}")
    public Long addItem(@PathVariable Long user_id, @RequestBody @Valid UserItem userItem) { return service.addUserItems(user_id, userItem); }

    @GetMapping(value = "/items/{user_id}")
    public Set<UserItem> getItems(@PathVariable Long user_id) { return service.getUserItems(user_id); }
}
