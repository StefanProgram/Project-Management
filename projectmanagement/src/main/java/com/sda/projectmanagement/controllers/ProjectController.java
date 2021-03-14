package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.persistence.ProjectsEntity;
import com.sda.projectmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping(path = "getProjects")
    public String getProjects(Model model) {
        List<ProjectsEntity> projectList = projectService.getAllProjects();
        model.addAttribute("projects",projectList );
        return "projects";
    }

//    @PostMapping

}
