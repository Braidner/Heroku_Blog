package org.braidner.blog.service;

import org.braidner.blog.entity.Post;
import org.braidner.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Braidner
 */
@Service
public class PostService extends BaseService {

    @Autowired
    private PostRepository postRepository;

    public Post findPost(Long id) {
        return postRepository.findOne(id);
    }

    public Iterable<Post> findAllPosts() {
        return postRepository.findAll();
    }

}
