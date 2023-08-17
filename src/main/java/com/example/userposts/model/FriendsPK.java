package com.example.userposts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendsPK implements Serializable {
    private User whoAdd;
    private User whoShouldAccept;
}

