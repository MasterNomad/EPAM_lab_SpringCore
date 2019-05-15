package org.shop.config;

import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.initializer.*;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

public class DataConfig {

    @Bean(initMethod = "initData")
    public DataInitializer dataInitializer() {
        return new DataInitializer();
    }

    @Bean
    public UserInitializer userInitializer(UserService userService) {
        return new UserInitializer(userService);
    }

    @Bean
    public ProposalInitializer proposalInitializer() {
        return new ProposalInitializer();
    }

    @Bean
    public ProductInitializer productInitializer(ProductService productService) {
        return new ProductInitializer(productService);
    }

    @Bean
    public SellerInitializer sellerInitializer() {
        return new SellerInitializer();
    }

}
