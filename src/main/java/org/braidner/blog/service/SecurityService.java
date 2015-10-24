package org.braidner.blog.service;

import org.springframework.stereotype.Service;

/**
 * Created by Braidner on 9/4/2015.
 */
@Service
public class SecurityService {

////    @Autowired
//    private UserRepository userRepository;
//
//    public boolean isLogined() {
//        return false;
//    }
//
//    public Profile login(String login, String password, OAuthProvider provider, String oauthId) throws Exception {
//        UserFilter userFilter = new UserFilter(login, password, provider, oauthId);
//        Profile profile = userRepository.findUser(userFilter);
//
//        if (profile == null) {
//            throw new Exception("Profile not found");
//        }
//
//        return profile;
//    }
//
//    public Profile createUser(Profile profile) {
//        return userRepository.createUser(profile);
//    }
//
//    public Profile test() {
//        Profile profile = new Profile();
//        return profile;
//    }
}
