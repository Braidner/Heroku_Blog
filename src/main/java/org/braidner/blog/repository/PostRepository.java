package org.braidner.blog.repository;

import org.braidner.blog.entity.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Braidner
 */
public interface PostRepository extends CrudRepository<Post, Long> {
}
