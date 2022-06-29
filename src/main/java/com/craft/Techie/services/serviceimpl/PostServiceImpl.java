package com.craft.Techie.services.serviceimpl;

import com.craft.Techie.dao.PostDAO;
import com.craft.Techie.entities.Post;

import java.util.List;

/*
 * Declare CRUD operations for Post
 */
public interface PostServiceImpl {
    public PostDAO addPost(PostDAO postDAO, int userId);
    public boolean deletePost(int postId);
    public PostDAO getPost(int postId);
    public List<PostDAO> getAllPostOfUser(int userId);
}
