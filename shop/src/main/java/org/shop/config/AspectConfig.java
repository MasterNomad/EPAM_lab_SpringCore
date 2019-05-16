package org.shop.config;

import org.shop.aspect.LoggerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfig {

    @Bean
    public LoggerAspect loggerAspect() {
        return new LoggerAspect();
    }

}
