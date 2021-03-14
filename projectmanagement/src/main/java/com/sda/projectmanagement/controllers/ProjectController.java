package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.persistence.ProjectsEntity;
import com.sda.projectmanagement.service.ProjectManagementService;
import com.sda.projectmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private ProjectManagementService projectManagementService;

    @GetMapping(path = "getProjectManagement")
    public String getProjectManagement(Model model){
        List<ProjectsEntity> projectEntityList = projectManagementService.getAllProjects();
        model.addAttribute("ProjectManagement",projectEntityList);
        return "ProjectManagement";
    }

    @Autowired
    private ProjectService projectService;

    @GetMapping(path = "getProjects")
    public String getProjects(Model model) {
        List<ProjectsEntity> projectList = projectService.getAllProjects();
        model.addAttribute("projects", projectList);
        return "projects";
    }
    @GetMapping(path = "add-project")
    public String addBookPage(Model model) {
        model.addAttribute("newProject", new ProjectsEntity());
        return "add-project";
    }

    @PostMapping(path = "project/add")
    public String addBook(@ModelAttribute ProjectsEntity newProject) {
        projectService.addProject(newProject);
        return "redirect:/getProjects";
    }
}
