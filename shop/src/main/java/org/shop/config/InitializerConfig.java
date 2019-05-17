package org.shop.config;

import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.initializer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class InitializerConfig {

    @Bean(initMethod = "initData")
    public DataInitializer dataInitializer() {
        DataInitializer dataInitializer = new DataInitializer();

        try {
            Field field = DataInitializer.class.getDeclaredField("seller");
            field.setAccessible(true);
            ReflectionUtils.setField(field, dataInitializer, sellerInitializer());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return dataInitializer;
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
    public Map<Long, String> sellersName() {
        Map<Long, String> map = new HashMap<>();
        map.put(1L, "seller 1");
        map.put(2L, "seller 2");
        return map;
    }

    @Bean
    public SellerInitializer sellerInitializer() {
        return new SellerInitializer();
    }

}
