package com.sda.projectmanagement.repositories;

import com.sda.projectmanagement.persistence.ParticipationInProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipationRepository extends JpaRepository<ParticipationInProjectEntity, Integer> {
}
