package com.felipe.workshopspringmongodb.domain;

import com.felipe.workshopspringmongodb.dto.AuthorDTO;
import com.felipe.workshopspringmongodb.dto.CommentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@Document
public class Post {
    @Id
    private String id;
    private Date date;
    private String title;
    private String body;    private AuthorDTO author;

    private List<CommentDTO> comment = new ArrayList<>();

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.body = body;
        this.title = title;
        this.author = author;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id.equals(post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

