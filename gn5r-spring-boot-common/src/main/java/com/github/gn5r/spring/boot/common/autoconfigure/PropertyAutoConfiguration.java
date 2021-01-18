package com.github.gn5r.spring.boot.common.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.gn5r.spring.boot.common.env.ApplicationProperty;

@Configuration
@EnableConfigurationProperties
public class PropertyAutoConfiguration {

    @Bean
    @ConfigurationProperties(prefix = ApplicationProperty.PREFIX)
    public ApplicationProperty applicationProperty() {
        return new ApplicationProperty();
    }
}
