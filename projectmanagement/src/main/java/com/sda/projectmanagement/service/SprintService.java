package com.sda.projectmanagement.service;

import com.sda.projectmanagement.persistence.SprintEntity;
import com.sda.projectmanagement.repositories.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    public SprintRepository getSprintRepository() { return sprintRepository; }

    public void setSprintRepository(SprintRepository sprintRepository){
    this.sprintRepository = sprintRepository;

    }

    public void addSprint(SprintEntity newSprint) { sprintRepository.save(newSprint);}


    public List<SprintEntity> getAllSprint() { return sprintRepository.findAll(); }

    public void editSprint(SprintEntity editedSprint) { sprintRepository.save(editedSprint);}

    public void deleteSprint(Integer id){
        sprintRepository.deleteById(id);
    }
    public SprintEntity getSprint(Integer id) {
        Optional<SprintEntity> sprintEntityOptional = sprintRepository.findById(id);
        SprintEntity sprintEntity = sprintEntityOptional.get();
        return sprintEntity;
    }

}
