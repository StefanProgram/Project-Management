package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.persistence.ProjectsEntity;
import com.sda.projectmanagement.persistence.UsersEntity;
import com.sda.projectmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/getUsers")
    public String getUsers(Model model) {
        List<UsersEntity> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "users";
    }

    @GetMapping(path = "add-project")
    public String addBookPage(Model model) {
        model.addAttribute("newProject", new UsersEntity());
        return "add-project";
    }

    @PostMapping(path = "project/add")
    public String addBook(@ModelAttribute UsersEntity newProject) {
        userService.addUser(newProject);
        return "redirect:/getProjects";
    }
}
