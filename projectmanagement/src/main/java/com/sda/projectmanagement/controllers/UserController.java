package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.persistence.UsersEntity;
import com.sda.projectmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(path = "add-user")
    public String addUserPage(Model model) {
        model.addAttribute("newUser", new UsersEntity());
        return "add-user";
    }

    @PostMapping(path = "user/add")
    public String addUser(@ModelAttribute UsersEntity newUser) {
        userService.addUser(newUser);
        return "redirect:/getUsers";
    }
    @GetMapping(path = "edit-user/{id}")
    public String editUserPage(Model model, @PathVariable("id") Integer id){
        UsersEntity usersEntity = userService.getUser(id);
        model.addAttribute("userToBeEdited", usersEntity);
        return "edit-user";
    }

    @PostMapping(path = "user/edit")
    public String editUser(@ModelAttribute UsersEntity userToBeEdited){
        userService.editUser(userToBeEdited);
        return "redirect:/getUsers";
    }

    @GetMapping(path = "delete-user/{id}")
    public String deleteUser(Model model, @PathVariable("id") Integer id){
        userService.deleteUser(id);
        return "redirect:/getUsers";
    }

}
