package com.example.userposts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.validator.constraints.UUID;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Column(name = "user_id")
    @Id
    @UUID(message = "User id should be in UUID format.")
    private String id;

    @Column(name = "image_url")
    private String imageUrl;

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
