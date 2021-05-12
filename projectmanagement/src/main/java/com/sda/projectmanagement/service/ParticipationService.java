package com.sda.projectmanagement.service;

import com.sda.projectmanagement.persistence.ParticipationInProjectEntity;
import com.sda.projectmanagement.repositories.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationService {
    @Autowired
    private ParticipationRepository participationRepository;

    public ParticipationRepository getParticipationInProjectRepository() {
        return participationRepository;
    }

    public void setParticipationInProjectRepository(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public void addParticipation(ParticipationInProjectEntity newParticipation) {
        participationRepository.save(newParticipation);
    }

    public List<ParticipationInProjectEntity> getAllParticipations() {
        return participationRepository.findAll();
    }

    public void editParticipation(ParticipationInProjectEntity editedParticipation) {
        participationRepository.save(editedParticipation);
    }

    public void deleteParticipation(ParticipationInProjectEntity participationEntity) {
        participationRepository.deleteById(participationEntity.getParticipationId());
    }
}
