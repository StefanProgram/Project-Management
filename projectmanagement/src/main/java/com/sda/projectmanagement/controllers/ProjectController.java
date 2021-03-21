package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.persistence.ProjectsEntity;
import com.sda.projectmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping(path = "getProjects")
    public String getProjects(Model model) {
        List<ProjectsEntity> projectsList = projectService.getAllProjects();
        model.addAttribute("projects", projectsList);
        return "projects";
    }

    @GetMapping(path = "add-project")
    public String addProjectPage(Model model) {
        model.addAttribute("newProject", new ProjectsEntity());
        return "add-project";
    }

    @PostMapping(path = "project/add")
    public String addProject(@ModelAttribute ProjectsEntity newProject) {
        projectService.addProject(newProject);
        return "redirect:/getProjects";
    }

    @GetMapping(path = "edit-project/{id}")
    public String editProjectPage(Model model, @PathVariable("id") Integer id) {
        ProjectsEntity projectsEntity = projectService.getProject(id);
        model.addAttribute("projectToBeEdited", projectsEntity);
        return "edit-project";
    }

    @PostMapping(path = "project/edit")
    public String editProject(@ModelAttribute ProjectsEntity projectToBeEdited) {
        projectService.editProject(projectToBeEdited);
        return "redirect:/getProjects";
    }

    @GetMapping(path = "delete-project/{id}")
    public String deleteProject(Model model, @PathVariable("id") Integer id) {
        projectService.deleteProject(id);
        return "redirect:/getProjects";
    }

}
