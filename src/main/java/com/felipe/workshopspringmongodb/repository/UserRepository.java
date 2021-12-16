package com.felipe.workshopspringmongodb.repository;

import com.felipe.workshopspringmongodb.domain.User;
import com.felipe.workshopspringmongodb.dto.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,  String> {

}
