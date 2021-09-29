package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Primary
@Service
public class ConsoleGreetingService implements GreetingService {

// 以下是 https://dev-mind.fr/training/spring/spring-ioc.html 中最后一步 “other cases”中添加的内容
//    private final CycleService cycleService;
//
//    @Autowired
//    public ConsoleGreetingService(CycleService cycleService) {
//        this.cycleService = cycleService;
//    }

    @Override
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
}


