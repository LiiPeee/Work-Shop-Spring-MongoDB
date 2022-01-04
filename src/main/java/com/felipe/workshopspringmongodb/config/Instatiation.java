package com.felipe.workshopspringmongodb.config;

import com.felipe.workshopspringmongodb.domain.Post;
import com.felipe.workshopspringmongodb.domain.User;
import com.felipe.workshopspringmongodb.dto.AuthorDTO;
import com.felipe.workshopspringmongodb.dto.CommentDTO;
import com.felipe.workshopspringmongodb.repository.PostRepository;
import com.felipe.workshopspringmongodb.repository.UserRepository;
import com.felipe.workshopspringmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instatiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;

    public Instatiation() {
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        userService.deleteAll();
        postRepository.deleteAll();
        User maria = new User(null, "Maria", "mariasl@gmail.com");
        User joao = new User(null, "Joao", "joaosl@gmail.com");
        User bob = new User(null, "bob", "bobsl@gmail.com");

        userService.save(Arrays.asList(maria, joao, bob));



        Post post1 = new Post("2", sdf.parse("28/08/2018"), "Partiu Viagem", "Vamo para São Paulo", new AuthorDTO(maria));
        Post post2 = new Post("2", sdf.parse("27/08/2018"), "Partiu Viagem", "Vamo para Recife ", new AuthorDTO(joao));

        CommentDTO c1 = new CommentDTO("Boa viagem", sdf.parse("21/03/2018"),new AuthorDTO(joao));
        CommentDTO c2 = new CommentDTO("Boa viagem", sdf.parse("21/03/2018"),new AuthorDTO(maria));

        post1.getComment().addAll(Arrays.asList(c1,c2));
        post2.getComment().addAll(Arrays.asList(c1,c2));


        postRepository.save(post1);


        maria.setPosts(Arrays.asList(post1));
        userRepository.save(maria);





//        postRepository.save(Arrays.asList(post1));

//        list.addAll(Arrays.asList(post1));
//        for (Post post: list) {
//            postRepository.save(post);
//
//        }


    }
}
