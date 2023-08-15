package com.example.userposts.dto.response;

import lombok.Data;
import org.hibernate.validator.constraints.UUID;

@Data
public class UserDTO {
    @UUID(message = "User id should be in UUID format.")
    private String id;
    private String imageUrl;
}
