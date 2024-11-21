package com.sadlier.sadlier_gateway.client;

import com.example.account.AccountProto;
import com.example.account.AccountServiceGrpc;
import com.sadlier.sadlier_gateway.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceClient {
    private final AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub;

    @Autowired
    public AccountServiceClient(AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub) {
        this.accountServiceBlockingStub = accountServiceBlockingStub;
    }

    public UserDTO getUserInfo(String userId) {
        AccountProto.UserRequest request = AccountProto.UserRequest.newBuilder()
                .setUserId(userId)
                .build();

        AccountProto.UserResponse response = accountServiceBlockingStub.getUserInfo(request);
        return new UserDTO(response.getName(), request.getUserId());
    }
}
