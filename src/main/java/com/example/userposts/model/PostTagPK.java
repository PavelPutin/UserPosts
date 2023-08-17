package com.example.userposts.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostTagPK implements Serializable {
    private Post post;
    private Tag tag;
}
