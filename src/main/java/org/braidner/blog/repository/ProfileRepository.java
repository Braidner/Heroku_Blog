package org.braidner.blog.repository;

import org.braidner.blog.entity.Profile;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Braidner
 */
public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
