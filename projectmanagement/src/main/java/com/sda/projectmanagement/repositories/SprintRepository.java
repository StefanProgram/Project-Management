package com.sda.projectmanagement.repositories;

import com.sda.projectmanagement.persistence.ProjectsEntity;
import com.sda.projectmanagement.persistence.SprintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends JpaRepository<SprintEntity, Integer> {
}
