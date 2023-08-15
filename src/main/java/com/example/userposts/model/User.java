package com.example.userposts.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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

    @Transient
    public List<User> getFriends() {
        List<User> friends = new java.util.ArrayList<>(incoming.stream()
                .filter(Friends::isAccepted)
                .map(Friends::getWhoAdd)
                .toList());
        Stream<User> outgoingFriendsStream= outgoing.stream()
                .filter(Friends::isAccepted)
                .map(Friends::getWhoShouldAccept);
        friends.addAll(outgoingFriendsStream.toList());
        return friends;
    }
}
