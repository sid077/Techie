package com.craft.Techie.controllers;

import com.craft.Techie.dao.PostDAO;
import com.craft.Techie.entities.Post;
import com.craft.Techie.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/getPost/{id}")
    public ResponseEntity<PostDAO> getPostById(@PathVariable("id") int postId){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPost(postId));
    }
    @GetMapping("/getAllPost/{id}")
    public ResponseEntity<List<PostDAO>> getAllPostByUserId(@PathVariable("id") int userId){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPostOfUser(userId));
    }
    @PostMapping("/addPost/{id}")
    public ResponseEntity<PostDAO> addPost(@PathVariable("id") int userId,@RequestBody PostDAO postDAO){
        return ResponseEntity.status(HttpStatus.OK).body(postService.addPost(postDAO, userId));
    }
    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable("id") int postId){
        return ResponseEntity.status(HttpStatus.OK).body(postService.deletePost(postId));
    }


}
