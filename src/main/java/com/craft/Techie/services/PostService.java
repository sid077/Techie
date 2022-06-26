package com.craft.Techie.services;

import com.craft.Techie.dao.PostDAO;
import com.craft.Techie.repositories.PostRepository;
import com.craft.Techie.services.serviceimpl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostService implements PostServiceImpl {
    @Autowired
    PostRepository postRepository;
    @Override
    public boolean addPost(PostDAO postDAO) {
        return false;
    }

    @Override
    public boolean deletePost(int postId) {
        return false;
    }

    @Override
    public PostDAO getPost(int postId) {
        return null;
    }

    @Override
    public List<PostDAO> getAllPostOfUser(int userId) {
        return null;
    }
}
