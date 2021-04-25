package com.vishnu.learning.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService{

    @Cacheable(value = "addresses", key = "#root.methodName")
    public String sayHello() {
        return getString();
    }

    private String getString() {
        return "Hello String";
    }

}
