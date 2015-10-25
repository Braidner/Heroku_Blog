package org.braidner.blog.service;

import org.braidner.blog.entity.Profile;
import org.braidner.blog.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Braidner
 */
@Service("securityService")
public class SecurityService extends BaseService {

    @Autowired private ProfileRepository profileRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile profile = profileRepository.findByUsername(username);
        if (profile == null) {
            throw new UsernameNotFoundException("User with login " + username + " not found");
        }
        return profile;
    }
}
