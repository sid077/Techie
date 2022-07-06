package com.craft.Techie.services;

import com.craft.Techie.dao.PostDAO;
import com.craft.Techie.entities.Post;
import com.craft.Techie.entities.User;
import com.craft.Techie.exceptions.EntityNotFound;
import com.craft.Techie.repositories.PostRepository;
import com.craft.Techie.repositories.UserRepository;
import com.craft.Techie.services.serviceimpl.PostServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService implements PostServiceImpl {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public PostDAO addPost(PostDAO postDAO, int userId) {
        Post post = PostDAO.convertToEntity(postDAO);
        User postingUser = userRepository.findById(userId)
                .orElseThrow(()->new EntityNotFound("post",String.valueOf(userId)));
        post.setUser(postingUser);
        post = postRepository.save(post);
        postDAO = modelMapper.map(post, PostDAO.class);
        return postDAO;
    }

    @Override
    public boolean deletePost(int postId) {
        postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFound("post",String.valueOf(postId)));
        postRepository.deleteById(postId);
        return true;
    }

    @Override
    public PostDAO getPost(int postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFound("post",String.valueOf(postId)));
        PostDAO postDAO = modelMapper.map(post, PostDAO.class);
        return postDAO;
    }

    @Override
    public List<PostDAO> getAllPostOfUser(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFound("User",String.valueOf(userId)));
        List<Post> postDAOList = user.getPosts();
        List<PostDAO> postDAOS = new ArrayList<>();
        for(Post post: postDAOList){
            PostDAO postDAO = modelMapper.map(post, PostDAO.class);
            postDAOS.add(postDAO);
        }
        return postDAOS;
    }
}
