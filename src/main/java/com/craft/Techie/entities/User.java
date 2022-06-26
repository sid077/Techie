package com.craft.Techie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String firstName;
    String lastName;
    String designation;
    String highlight;
    String company;

    @OneToMany(mappedBy = "user")
    List<Post> posts;

    //TODO: Followers, projects, chat to be implemented

}
