package com.emse.spring.faircorp.hello;

import org.apache.el.parser.AstGreaterThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DummyUserService implements UserService {
    @Autowired
    GreetingService greetingService;

    @Override
    public void greetAll() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Elodie");
        strings.add("Charles");

        for(String name: strings){
            greetingService.greet(name);
        }
    }
}
