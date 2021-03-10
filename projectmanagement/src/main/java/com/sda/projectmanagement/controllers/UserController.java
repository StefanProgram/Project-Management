package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.repositories.ProjectRepository;
import com.sda.projectmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
}
