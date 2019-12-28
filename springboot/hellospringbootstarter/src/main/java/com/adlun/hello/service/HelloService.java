package com.adlun.hello.service;

import com.adlun.hello.utils.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloProperties properties;

    public String sayHello(){
        return "welcome," + properties.getName();
    }
}
