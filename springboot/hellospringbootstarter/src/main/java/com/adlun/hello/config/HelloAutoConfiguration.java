package com.adlun.hello.config;

import com.adlun.hello.service.HelloService;
import com.adlun.hello.utils.HelloProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)
public class HelloAutoConfiguration {

    @Bean
    @ConditionalOnProperty(value = "adlun.name")
    public HelloService helloService(){
        return new HelloService();
    }
}
