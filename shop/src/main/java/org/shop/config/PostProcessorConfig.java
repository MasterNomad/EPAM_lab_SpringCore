package org.shop.config;

import org.shop.annotation.InjectRandomIntAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;

public class PostProcessorConfig {

    @Bean
    public InjectRandomIntAnnotationBeanPostProcessor injectRandomIntAnnotationBeanPostProcessor() {
        return new InjectRandomIntAnnotationBeanPostProcessor();
    }

}
