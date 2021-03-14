package com.sda.projectmanagement.service;

import com.sda.projectmanagement.persistence.ProjectEntity;
import com.sda.projectmanagement.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectManagementService {

    @Autowired
    private ProjectRepository projectRepository;

    public void addProject(ProjectEntity newProject) { projectRepository.save(newProject);}

public List<ProjectEntity> getProjectManagement(){
        List<ProjectEntity> projectList = projectRepository.findAll();
        List<ProjectEntity> filteredProject = projectList.stream().filter(projectEntity ->
                projectEntity.getDescription().contains("jungle")).collect(Collectors.toList());

        return projectList;
}
public List<ProjectEntity> getAllProjects() {return projectRepository.findAll(); }

public void deleteProject(Integer id){ projectRepository.deleteById(id); }

public void editProject(ProjectEntity editedProject) { projectRepository.save(editedProject) ;}

public void setProjectRepository(ProjectRepository projectRepository) {this.projectRepository = projectRepository;}

public ProjectRepository getProjectRepository() { return projectRepository; }
}
