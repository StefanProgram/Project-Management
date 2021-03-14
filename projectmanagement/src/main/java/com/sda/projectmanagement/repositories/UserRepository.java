package com.sda.projectmanagement.repositories;

import com.sda.projectmanagement.persistence.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
}
