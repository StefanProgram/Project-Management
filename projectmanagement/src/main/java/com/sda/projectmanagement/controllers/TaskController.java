package com.sda.projectmanagement.controllers;

import com.sda.projectmanagement.persistence.TaskEntity;
import com.sda.projectmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping(path="add-task")
    public String getTaskPage(Model model) {
        model.addAttribute("newTask", new TaskEntity());
        return "add-task";
    }

    @PostMapping(path="task/add")
    public String addTaskPage(@ModelAttribute TaskEntity newTask){
        taskService.addTask(newTask);
        return"redirect:/getTask";
    }

    @GetMapping(path="edit-task/{id}")
    public String editTaskPage(Model model, @PathVariable("id") Integer id) {
        TaskEntity taskEntity = taskService.getTask(id);
        model.addAttribute("taskToBeEdited", taskEntity);
        return "edit-task";
    }

    @PostMapping(path="task/edit")
    public String editTaskPage(@ModelAttribute TaskEntity taskToBeEdited){
        taskService.editTask(taskToBeEdited);
        return"redirect:/getTask";
    }

    @GetMapping(path="delete-task/{id}")
    public String deleteTask(Model model, @PathVariable("id") Integer id){
        taskService.deleteTask(id);
        return "redirect:/getTask";
    }
}
