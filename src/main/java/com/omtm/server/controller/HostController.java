package com.omtm.server.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Api(value = "host", tags = "Host IP Address")
@RestController
@RequestMapping("/api")
public class HostController {

    @GetMapping(value = "/host")
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
}
