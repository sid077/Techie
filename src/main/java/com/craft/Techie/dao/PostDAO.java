package com.craft.Techie.dao;

import com.craft.Techie.entities.Post;
import com.craft.Techie.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
public class PostDAO {
    int id;
    String title;
    String description;
    String tag;
    String imageUrl;
    String videoUrl;
    List<String> keywords;
    int likes;

    public static Post convertToEntity(PostDAO postDAO) {
        Post post = new Post();
        post.setId(postDAO.getId());
        post.setTitle(postDAO.getTitle());
        post.setDescription(postDAO.getDescription());
        post.setTag(postDAO.getTag());
        post.setImageUrl(postDAO.getImageUrl());
        post.setVideoUrl(postDAO.getVideoUrl());
        post.setKeywords(postDAO.getKeywords());
        post.setLikes(postDAO.getLikes());
        return post;
    }
}
