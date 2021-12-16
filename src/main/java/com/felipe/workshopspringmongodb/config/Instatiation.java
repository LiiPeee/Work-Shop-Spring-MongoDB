package com.felipe.workshopspringmongodb.config;

import com.felipe.workshopspringmongodb.domain.User;
import com.felipe.workshopspringmongodb.repository.UserRepository;
import com.felipe.workshopspringmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instatiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        User maria = new User(null,"Maria","mariasl@gmail.com");
        User joao = new User(null,"Joao","joaosl@gmail.com");
        User bob = new User(null,"bob","bobsl@gmail.com");
        User tiago = new User(null,"tiago","tiagosl@gmail.com");
        User felipe = new User(null,"felipe","felipesl@gmail.com");
        User rodolfo = new User(null,"rodolfo","rodolfosl@gmail.com");


        userService.save(Arrays.asList(maria,joao,bob,tiago,felipe,rodolfo));

//        list.addAll(Arrays.asList(maria,joao,bob));
//        for (User user: list) {
//            userRepository.save(user);
//
//        }



    }
}
