package com.sda.projectmanagement.repositories;

import com.sda.projectmanagement.persistence.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
    public UsersEntity findByEmail(String email);
    public Optional<UsersEntity> findByLogin(String login);
}
