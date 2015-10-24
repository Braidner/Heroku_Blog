package org.braidner.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Braidner
 */
@Controller
public class AppController {

    @RequestMapping({"", "blog/**", "auth/**"})
    public String app() {
        System.out.println("index");
        return "forward:/pages/index.html";
    }
}
