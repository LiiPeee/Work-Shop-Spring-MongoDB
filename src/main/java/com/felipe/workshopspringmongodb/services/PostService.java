package com.felipe.workshopspringmongodb.services;

import com.felipe.workshopspringmongodb.domain.Post;
import com.felipe.workshopspringmongodb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    private PostService(PostRepository repo){
        this.repo = repo;
    }
    public Post findById(String id) {
        Optional<Post> user = repo.findById(id);
        if (user.isPresent()) {
          return user.get();
        }
        throw new ObjectNotFoundException("Objeto não encontrado");
    }
    public List<Post> findByTitle(String text){
        return repo.findByTitleContaining(text);
    }
}
