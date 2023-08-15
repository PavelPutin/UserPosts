package com.example.userposts.dto;

public class OutgoingFriendsDTO {
    private UserDTO whoShouldAccept;
    private boolean accepted;

    public UserDTO getWhoShouldAccept() {
        return whoShouldAccept;
    }

    public void setWhoShouldAccept(UserDTO whoShouldAccept) {
        this.whoShouldAccept = whoShouldAccept;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
