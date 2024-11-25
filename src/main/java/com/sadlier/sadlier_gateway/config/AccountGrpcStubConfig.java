package com.sadlier.sadlier_gateway.config;


import com.sadlier.account.AccountServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountGrpcStubConfig {
    @Bean
    public AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub(@Qualifier("AccountGrpcChannel") ManagedChannel channel) {
        return AccountServiceGrpc.newBlockingStub(channel);
    }
}
