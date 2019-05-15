package org.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Import({ServiceConfig.class, RepositoryConfig.class, DataConfig.class, FactoryConfig.class})
public class AppConfig {
}
