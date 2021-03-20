package com.sda.projectmanagement.service;

import com.sda.projectmanagement.persistence.ProjectsEntity;
import com.sda.projectmanagement.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void addProject(ProjectsEntity newProject) {
        projectRepository.save(newProject);
    }

    public List<ProjectsEntity> getAllProjects() {
        return projectRepository.findAll();
    }

    public void editProject(ProjectsEntity editedProject) {
        projectRepository.save(editedProject);
    }

    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }
    public ProjectsEntity getProject(Integer id) {
        Optional<ProjectsEntity> projectsEntityOptional =  projectRepository.findById(id);
        ProjectsEntity projectsEntity = projectsEntityOptional.get();
        return projectsEntity;
    }


}
