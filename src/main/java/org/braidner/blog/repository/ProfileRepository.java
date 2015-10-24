package org.braidner.blog.repository;

import org.braidner.blog.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Braidner
 */
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile findByUsername(String username);
}
