package com.example.userposts.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity(name = "posts")
@Data
@NoArgsConstructor
public class Post {
    @Column(name = "post_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    @NotEmpty(message = "Post's title should not be empty")
    @Size(max = 255, message = "Post's title length should be less than 256 characters")
    private String title;

    @NotEmpty(message = "Post's body should not be empty")
    private String body;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author", referencedColumnName = "user_id")
    private User author;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
