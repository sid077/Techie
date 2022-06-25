package com.craft.Techie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String title;
    String description;

    // for frontend segregation
    String tag;

    String imageUrl;
    String videoUrl;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<String> keywords;

    int likes;

    //TODO: comments to be implemented

}
