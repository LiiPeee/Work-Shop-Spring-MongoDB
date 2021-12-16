package com.felipe.workshopspringmongodb.services;

import com.felipe.workshopspringmongodb.domain.User;
import com.felipe.workshopspringmongodb.dto.UserDTO;
import com.felipe.workshopspringmongodb.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public User findById(String id) {
        Optional<User> user = repo.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new ObjectNotFoundException("Objeto não encontrado");

    }


    public User save(User user) {
        return repo.save(user);
    }

    public List<User> save(List<User> user) {
        return repo.saveAll(user);

    }

    public List<User> findAll() {
        return repo.findAll();
    }

}
