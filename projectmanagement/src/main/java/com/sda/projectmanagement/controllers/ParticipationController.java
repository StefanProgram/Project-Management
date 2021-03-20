package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.persistence.ParticipationInProjectEntity;
import com.sda.projectmanagement.persistence.ProjectsEntity;
import com.sda.projectmanagement.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ParticipationController {
@Autowired
    private ParticipationService participationService;

    @GetMapping(path = "getParticipation")
    public String getParticipation(Model model) {
        List<ParticipationInProjectEntity> participationList = participationService.getAllParticipations();
        model.addAttribute("participations", participationList);
        return "participations";
    }
}
