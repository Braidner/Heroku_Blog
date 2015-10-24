package org.braidner.blog.controller.rest;

import org.braidner.blog.controller.exception.BadRequestException;
import org.braidner.blog.controller.exception.ResourceNotFoundException;
import org.braidner.blog.entity.Profile;
import org.braidner.blog.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Braidner on 9/8/2015.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "create")
    public Profile createUser() {
        Profile profile = new Profile();
        profile.setUsername("Braidner");
        profile.setPassword("123");
//        profile = securityService.createUser(profile);
        if (profile == null) {
            throw new BadRequestException();
        }
        return profile;
    }

    @RequestMapping("find")
    public Profile findUser() {
        throw new ResourceNotFoundException("User not found");
    }

    @RequestMapping("all")
    public List<Profile> showUsers() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Admin", "123"));
        profiles.add(new Profile("Admin123", "123312"));
        profiles.add(new Profile("Admin23", "12342"));
        profiles.add(new Profile("Admin1", "1234"));

        return profiles;
    }
}
