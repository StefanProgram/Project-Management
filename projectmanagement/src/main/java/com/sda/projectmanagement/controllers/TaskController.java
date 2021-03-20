package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.persistence.TaskEntity;
import com.sda.projectmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping(path= "/getTaskController")
    public String getTask(Model model) {
        List<TaskEntity> taskEntityList = taskService.getAllTask();
        model.addAttribute("task", taskEntityList);
        return "task";
    }

}
