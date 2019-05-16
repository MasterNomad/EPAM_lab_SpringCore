package org.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAspectJAutoProxy
@PropertySource("application.properties")
@Import({ServiceConfig.class, RepositoryConfig.class, InitializerConfig.class,
        FactoryConfig.class, PostProcessorConfig.class, AspectConfig.class})
public class AppConfig {

}
