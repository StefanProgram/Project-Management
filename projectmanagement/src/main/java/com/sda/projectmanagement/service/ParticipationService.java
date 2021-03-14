package com.sda.projectmanagement.service;

import com.sda.projectmanagement.persistence.ParticipationInProjectEntity;
import com.sda.projectmanagement.persistence.UsersEntity;
import com.sda.projectmanagement.repositories.ParticipationInProjectRepository;
import com.sda.projectmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParticipationInProjectService {
    @Autowired
    private ParticipationInProjectRepository participationInProjectRepository;

    public ParticipationInProjectRepository getParticipationInProjectRepository() {
        return participationInProjectRepository;
    }

    public void setParticipationInProjectRepository(ParticipationInProjectRepository participationRepository) {
        this.participationInProjectRepository = participationRepository;
    }

    public void addParticipation(ParticipationInProjectEntity newParticipation) {
        participationInProjectRepository.save(newParticipation);
    }

    public List<ParticipationInProjectEntity> getAllParticipations() {
        return participationInProjectRepository.findAll();
    }

    public void editParticipation(ParticipationInProjectEntity editedParticipation) {
        participationInProjectRepository.save(editedParticipation);
    }

    public void deleteParticipation(ParticipationInProjectEntity participationEntity) {
        participationInProjectRepository.deleteById(participationEntity.getParticipationId());
    }
}
