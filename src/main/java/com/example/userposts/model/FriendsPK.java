package com.example.userposts.model;

import java.io.Serializable;
import java.util.Objects;

public class FriendsPK implements Serializable {
    private User whoAdd;
    private User whoShouldAccept;

    private FriendsPK() {
    }

    public FriendsPK(User whoAdd, User whoShouldAccept) {
        this.whoAdd = whoAdd;
        this.whoShouldAccept = whoShouldAccept;
    }

    public User getWhoAdd() {
        return whoAdd;
    }

    public void setWhoAdd(User whoAdd) {
        this.whoAdd = whoAdd;
    }

    public User getWhoShouldAccept() {
        return whoShouldAccept;
    }

    public void setWhoShouldAccept(User whoShouldAccept) {
        this.whoShouldAccept = whoShouldAccept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendsPK friendsPK = (FriendsPK) o;
        return Objects.equals(getWhoAdd(), friendsPK.getWhoAdd()) && Objects.equals(getWhoShouldAccept(), friendsPK.getWhoShouldAccept());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWhoAdd(), getWhoShouldAccept());
    }
}

