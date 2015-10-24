package org.braidner.blog.controller.rest;

import org.braidner.blog.entity.Post;
import org.braidner.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author Braidner
 */
@RestController
@RequestMapping("/rest/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("all")
    public Iterable<Post> findPosts(Principal principal) {
        if (principal != null) {
            System.out.println(principal);
        }
        Iterable<Post> allPosts = postService.findAllPosts();
        return allPosts;
    }

    @RequestMapping("{postId}")
    public Post findPost(@PathVariable Long postId, Principal principal) {
        System.out.println(principal);
        return postService.findPost(postId);
    }

    @Secured("ROLE_DBA")
    @RequestMapping(method = RequestMethod.POST)
    public void createPost(@RequestBody Post post) {
        postService.savePost(post);
    }
}
