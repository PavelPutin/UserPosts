package com.example.userposts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity(name = "tags")
@Data
public class Tag implements Serializable {
    @Column(name = "tag_id")
    @Id
    private int id;

    @Column(name = "tag_name")
    @NotEmpty(message = "Tag should not be empty")
    @Size(max = 255, message = "Tag length should be less than 256 characters")
    private String name;

    @OneToMany(mappedBy = "tag")
    private List<PostTag> postTag;
}
