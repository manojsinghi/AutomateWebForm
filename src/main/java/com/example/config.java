package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    GenericPool generate(){
    GenericPool genericPool = new GenericPool(new WebdriverFactory(),new GenericPoolConfig());
    return genericPool;
    }

}
