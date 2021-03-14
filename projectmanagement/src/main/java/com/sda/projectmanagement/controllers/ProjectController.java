package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.persistence.ProjectEntity;
import com.sda.projectmanagement.service.ProjectManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectManagementService projectManagementService;

    @GetMapping(path = "getProjectManagement")
    public String getProjectManagement(Model model){
        List<ProjectEntity> projectEntityList = projectManagementService.getAllProjects();
        model.addAttribute("ProjectManagement",projectEntityList);
        return "ProjectManagement";
    }
}
