package com.example.userposts.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "friends")
@IdClass(FriendsPK.class)
public class Friends implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "who_add_user_id", referencedColumnName = "user_id")
    private User whoAdd;

    @Id
    @ManyToOne
    @JoinColumn(name = "who_should_accept_user_id", referencedColumnName = "user_id")
    private User whoShouldAccept;

    @Column(name = "is_accept")
    private boolean accepted;

    public FriendsPK getId() {
        return new FriendsPK(
                whoAdd,
                whoShouldAccept
        );
    }

    public void setId(FriendsPK id) {
        this.whoAdd = id.getWhoAdd();
        this.whoShouldAccept = id.getWhoShouldAccept();
    }

    public Friends() {
    }

    public Friends(User whoAdd, User whoShouldAccept, boolean accepted) {
        this.whoAdd = whoAdd;
        this.whoShouldAccept = whoShouldAccept;
        this.accepted = accepted;
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

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
