package com.example.userposts.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Entity(name = "users")
@NoArgsConstructor
@Data
public class User implements Serializable {

    @Column(name = "user_id")
    @Id
    @UUID(message = "User id should be in UUID format.")
    private String id;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "whoShouldAccept")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Friends> incoming;

    @OneToMany(mappedBy = "whoAdd")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Friends> outgoing;

    @OneToMany(mappedBy = "author")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @ManyToMany(mappedBy = "likes")
    private List<Comment> likedComments;

    @Transient
    public List<User> getFriends() {
        Stream<User> incomingFriendsStream = incoming.stream()
                .filter(Friends::isAccepted)
                .map(Friends::getWhoAdd);
        Stream<User> outgoingFriendsStream= outgoing.stream()
                .filter(Friends::isAccepted)
                .map(Friends::getWhoShouldAccept);
        return Stream.concat(incomingFriendsStream, outgoingFriendsStream).toList();
    }
}
