package com.felipe.workshopspringmongodb.services;

import com.felipe.workshopspringmongodb.domain.User;
import com.felipe.workshopspringmongodb.dto.UserDTO;
import com.felipe.workshopspringmongodb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;


    public UserService(UserRepository repo) {
        this.repo = repo;
    }
//    public UserService(PostRepository rep){
//        this.repo = repo;
//    }

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

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User update(User obj) {
        User newObj = repo.findById(obj.getId()).orElse(null);
        if (newObj != null)
            updateData(newObj, obj);

        return repo.findById(obj.getId()).orElse(null);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public void deleteById(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public void deleteAll (){
        repo.deleteAll();
    }
    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getEmail(), objDto.getName());
    }


}
