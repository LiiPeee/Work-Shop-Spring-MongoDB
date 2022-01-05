package com.felipe.workshopspringmongodb.resources;

import com.felipe.workshopspringmongodb.domain.Post;
import com.felipe.workshopspringmongodb.services.PostService;
import com.felipe.workshopspringmongodb.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.felipe.workshopspringmongodb.util.URL.decodeParam;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value= "/{id}")
    public  ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value= "/{titlesearch}")
    public  ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value= "/{fullsearch}")
    public  ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = decodeParam(text);
        Date min = URL.convertDate(minDate,new Date(0L));
        Date max = URL.convertDate(minDate,new Date());
        List<Post> list = service.fullSearch(text,min,max);
        return ResponseEntity.ok().body(list);
    }

}
