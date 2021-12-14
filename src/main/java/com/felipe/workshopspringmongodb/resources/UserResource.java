package com.felipe.workshopspringmongodb.resources;



import com.felipe.workshopspringmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>>findAll() {
        User felipe = new User ("1","Felipe","luiznuubb@gmail.com");
        User amanda = new User ("2","Amanda","luiznuubb@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(felipe,amanda));
        return ResponseEntity.ok().body(list);



    }

}
