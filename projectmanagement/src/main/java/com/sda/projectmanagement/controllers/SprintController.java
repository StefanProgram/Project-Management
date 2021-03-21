package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.persistence.SprintEntity;
import com.sda.projectmanagement.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping(path="add-sprint")
    public String addSprintPage(Model model) {
        model.addAttribute("newSprint",new SprintEntity());
        return "add-sprint";
    }
    @PostMapping(path="sprint/add")
    public String addSprintPage(@ModelAttribute SprintEntity newSprint){
        sprintService.addSprint(newSprint);
        return "redirect:/getSprint";
    }
    @GetMapping(path="edit-sprint/{id}")
    public String editSprintPage(Model model, @PathVariable("id") Integer id){
        SprintEntity sprintEntity = sprintService.getSprint(id);
        model.addAttribute("sprintToBeEdited", sprintEntity);
        return "edit-sprint";
    }
    @PostMapping(path="sprint/edit")
    public String editSpringPage(@ModelAttribute SprintEntity sprintToBeEdited){
        sprintService.editSprint(sprintToBeEdited);
        return "redirect:/getSprint";
    }
    @GetMapping(path="delete-sprint/{id}")
    public String deleteSprint(Model model, @PathVariable("id") Integer id){
        sprintService.deleteSprint(id);
        return "redirect:/getSprint";
    }
}
