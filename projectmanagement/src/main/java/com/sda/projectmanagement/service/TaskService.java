package com.sda.projectmanagement.service;

import com.sda.projectmanagement.persistence.SprintEntity;
import com.sda.projectmanagement.persistence.TaskEntity;
import com.sda.projectmanagement.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public  TaskRepository getTaskRepository() {return taskRepository ;}

    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

    }
    public void addTask(TaskEntity newTask) {taskRepository.save(newTask); }

    public List<TaskEntity> getAllTask() { return taskRepository.findAll(); }

    public void editTask(TaskEntity editedTask) { taskRepository.save(editedTask); }

    public void deleteTask(Integer id){
        taskRepository.deleteById(id);
    }
    public TaskEntity getTask(Integer id) {
        Optional<TaskEntity> taskEntityOptional = taskRepository.findById(id);
        TaskEntity taskEntity = taskEntityOptional.get();
        return taskEntity;
    }


}
