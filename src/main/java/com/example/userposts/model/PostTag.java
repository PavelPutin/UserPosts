package com.example.userposts.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "post_tags")
@Data
@IdClass(PostTagPK.class)
public class PostTag {
    @Id
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post post;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    private Tag tag;

    @Column(name = "tag_additional_name")
    private String additionalTagName;
}
