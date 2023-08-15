package com.example.userposts.dto.response;

import lombok.Data;

@Data
public class OutgoingFriendsDTO {
    private UserDTO whoShouldAccept;
    private boolean accepted;
}
