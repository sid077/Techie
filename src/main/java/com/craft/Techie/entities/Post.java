package com.craft.Techie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String title;
    String description;

    // for frontend segregation
    String tag;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id",nullable = false)
    User user;

    String imageUrl;
    String videoUrl;

    @ElementCollection
    List<String> keywords;

    int likes;

    //TODO: comments to be implemented

}
