package com.example.userposts.dto;

public class IncomingFriendsDTO {
    private UserDTO whoAdd;
    private boolean accepted;

    public UserDTO getWhoAdd() {
        return whoAdd;
    }

    public void setWhoAdd(UserDTO whoAdd) {
        this.whoAdd = whoAdd;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
