package com.vishnu.learning;

import com.vishnu.framework.annotations.EnableEntryExists;
import com.vishnu.learning.client.GreetingWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.security.Provider;

@SpringBootApplication
@EnableCaching
@EnableEntryExists(allowedAnnotations = {Service.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
        GreetingWebClient gwc = new GreetingWebClient();
        System.out.println(gwc.getResult());
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("addresses");
    }
}