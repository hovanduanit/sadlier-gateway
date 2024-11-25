package com.sadlier.sadlier_gateway.config;

import com.sadlier.product.ProductServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductGrpcStubConfig {
    @Bean
    public ProductServiceGrpc.ProductServiceBlockingStub accountServiceBlockingStub(@Qualifier("ProductGrpcChannel") ManagedChannel channel) {
        return ProductServiceGrpc.newBlockingStub(channel);
    }
}
