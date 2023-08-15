package com.example.userposts.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UUID;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Column(name = "user_id")
    @Id
    @UUID(message = "User id should be in UUID format.")
    private String id;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "whoShouldAccept")
    private List<Friends> incoming;

    @OneToMany(mappedBy = "whoAdd")
    private List<Friends> outgoing;

    public User() {
    }

    public User(String id, String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Friends> getIncoming() {
        return incoming;
    }

    public void setIncoming(List<Friends> incoming) {
        this.incoming = incoming;
    }

    public List<Friends> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(List<Friends> outgoing) {
        this.outgoing = outgoing;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getImageUrl(), user.getImageUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getImageUrl());
    }
}
