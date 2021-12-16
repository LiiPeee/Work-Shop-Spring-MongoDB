package com.felipe.workshopspringmongodb.dto;

import com.felipe.workshopspringmongodb.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private String id;
    private String name;
    private String email;



   public UserDTO(User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
   }





}
