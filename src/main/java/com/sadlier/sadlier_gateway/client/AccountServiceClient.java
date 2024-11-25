package com.sadlier.sadlier_gateway.client;


import com.sadlier.account.AccountProto;
import com.sadlier.account.AccountServiceGrpc;
import com.sadlier.product.ProductProto;
import com.sadlier.product.ProductServiceGrpc;
import com.sadlier.sadlier_gateway.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceClient {
    private final AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub;
    private final ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;

    @Autowired
    public AccountServiceClient(AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub, ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub) {
        this.accountServiceBlockingStub = accountServiceBlockingStub;
        this.productServiceBlockingStub = productServiceBlockingStub;
    }

    public UserDTO getUserInfo(String userId) {
        AccountProto.UserRequest request = AccountProto.UserRequest.newBuilder()
                .setUserId(userId)
                .build();
        ProductProto.ProductRequest request1 = ProductProto.ProductRequest.newBuilder()
                .setProductId(userId)
                .build();

        AccountProto.UserResponse response = accountServiceBlockingStub.getUserInfo(request);
        ProductProto.ProductResponse response1 = productServiceBlockingStub.getUserInfo(request1);
        return new UserDTO(response.getName(), request.getUserId());
    }
}
