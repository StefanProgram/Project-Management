package com.sda.projectmanagement.repositories;

import com.sda.projectmanagement.persistence.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {
}
