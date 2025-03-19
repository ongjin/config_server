package com.zerry.config_server.config;

import io.github.cdimascio.dotenv.Dotenv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.StandardEnvironment;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class EnvConfig {

    @Bean
    public MapPropertySource dotenvPropertySource(StandardEnvironment environment) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        Map<String, Object> properties = new HashMap<>();

        dotenv.entries().forEach(entry -> properties.put(entry.getKey(), entry.getValue()));

        MapPropertySource propertySource = new MapPropertySource("dotenv", properties);
        environment.getPropertySources().addLast(propertySource);
        return propertySource;
    }
}
