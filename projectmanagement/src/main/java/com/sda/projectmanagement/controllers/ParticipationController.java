package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.persistence.ParticipationInProjectEntity;
import com.sda.projectmanagement.persistence.ProjectsEntity;
import com.sda.projectmanagement.persistence.UsersEntity;
import com.sda.projectmanagement.service.ParticipationService;
import com.sda.projectmanagement.service.ProjectService;
import com.sda.projectmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ParticipationController {
    @Autowired
    private ParticipationService participationService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;


    @GetMapping(path = "getParticipation")
    public String getParticipation(Model model) {
        List<ParticipationInProjectEntity> participationList = participationService.getAllParticipations();
        model.addAttribute("participations", participationList);
        return "participations";
    }
    @GetMapping(path = "add-participation")
    public String addParticipation(Model model) {
        model.addAttribute("newParticipation", new ParticipationInProjectEntity());
        List<UsersEntity> usersEntity = userService.getAllUsers();
        model.addAttribute("users", usersEntity);
        List<ProjectsEntity> projectsEntity = projectService.getAllProjects();
        model.addAttribute("projects", projectsEntity);
        return "add-participation";
    }
    @PostMapping(path = "participation/add")
    public String addParticipation(@ModelAttribute ParticipationInProjectEntity newParticipation) {
        participationService.addParticipation(newParticipation);
        return "redirect:/getParticipation";
    }
}
