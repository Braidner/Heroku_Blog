package org.braidner.blog.controller.rest;

import org.braidner.blog.entity.Profile;
import org.braidner.blog.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Braidner on 9/5/2015.
 */
@RestController
@RequestMapping("security")
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @RequestMapping("login")
    public Principal login(Principal user) {
        UserDetails userDetails = securityService.loadUserByUsername(user.getName());
        System.out.println(user);
        return user;
    }

    @RequestMapping("logout")
    public String logout() {
        return null;
    }

    @RequestMapping("test")
    public Profile createUser() {
//        return securityService.test();
        return null;
    }
}
