package com.sadlier.sadlier_gateway.controller;

import com.sadlier.sadlier_gateway.client.AccountServiceClient;
import com.sadlier.sadlier_gateway.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountServiceClient accountServiceClient;

    @Autowired
    public AccountController(AccountServiceClient accountServiceClient) {
        this.accountServiceClient = accountServiceClient;
    }

    @GetMapping("/user-info")
    public UserDTO getUserInfo(@RequestParam String userId) {
        return accountServiceClient.getUserInfo(userId);
    }
}
