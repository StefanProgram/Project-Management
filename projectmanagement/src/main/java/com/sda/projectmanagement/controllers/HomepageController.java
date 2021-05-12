package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.persistence.UsersEntity;
import com.sda.projectmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getHomepage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        UsersEntity usersEntity = userService.getUserByUsername(login);
        return "start-page";
    }
}
