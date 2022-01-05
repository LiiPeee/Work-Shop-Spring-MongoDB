package com.felipe.workshopspringmongodb.services;

import com.felipe.workshopspringmongodb.domain.Post;
import com.felipe.workshopspringmongodb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class PostService {

    @Autowired
    private final PostRepository repo;


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
    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime()+24*60*60*1000);
        return repo.fullSearch(text, minDate, maxDate);
    }

}
