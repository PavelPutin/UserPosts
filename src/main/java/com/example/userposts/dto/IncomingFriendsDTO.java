package com.example.userposts.dto;

import lombok.Data;

@Data
public class IncomingFriendsDTO {
    private UserDTO whoAdd;
    private boolean accepted;
}
