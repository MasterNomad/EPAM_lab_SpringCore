package org.shop.config;

import org.shop.repository.*;
import org.shop.repository.factory.UserRepositoryFactory;
import org.shop.repository.map.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RepositoryConfig {

    @Bean
    public ItemRepository itemRepository() {
        return new ItemMapRepository();
    }

    @Bean
    public OrderRepository orderRepository() {
        return new OrderMapRepository();
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductMapRepository();
    }

    @Bean
    public ProposalRepository proposalRepository() {
        return new ProposalMapRepository();
    }

    @Bean
    public SellerRepository sellerRepository() {
        return new SellerMapRepository();
    }

    @Bean
    public UserRepository userRepository(UserRepositoryFactory userRepositoryFactory) {
        return userRepositoryFactory.createUserRepository();
    }
}
