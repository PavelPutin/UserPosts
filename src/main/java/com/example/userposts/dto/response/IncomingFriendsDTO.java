package com.example.userposts.dto.response;

import lombok.Data;

@Data
public class IncomingFriendsDTO {
    private UserDTO whoAdd;
    private boolean accepted;
}
