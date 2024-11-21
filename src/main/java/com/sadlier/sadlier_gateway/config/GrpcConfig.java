package com.sadlier.sadlier_gateway.config;

import com.example.account.AccountServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {
    @Bean
    public ManagedChannel accountServiceChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
    }

    @Bean
    public AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub(ManagedChannel channel) {
        return AccountServiceGrpc.newBlockingStub(channel);
    }
}
