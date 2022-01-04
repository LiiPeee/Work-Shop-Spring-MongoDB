package com.felipe.workshopspringmongodb.dto;

import com.felipe.workshopspringmongodb.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDTO {
    private String id;
    private String name;

    public  AuthorDTO(User obj){
        id = obj.getId();
        name = obj.getName();
    }

}
