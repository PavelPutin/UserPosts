package com.example.userposts.dto;

import lombok.Data;

@Data
public class OutgoingFriendsDTO {
    private UserDTO whoShouldAccept;
    private boolean accepted;
}
