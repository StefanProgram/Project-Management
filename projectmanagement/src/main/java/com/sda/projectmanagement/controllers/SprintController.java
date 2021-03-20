package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.persistence.SprintEntity;
import com.sda.projectmanagement.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SprintController {
    @Autowired
    private SprintService sprintService;

    @GetMapping(path= "/getSprintController")
    public String getSprint(Model model) {
        List<SprintEntity> sprintEntityList = sprintService.getAllSprint();
        model.addAttribute("sprint",sprintEntityList);
        return "sprint";
    }

}
