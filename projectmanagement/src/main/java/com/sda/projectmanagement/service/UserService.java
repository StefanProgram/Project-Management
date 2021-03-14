package com.sda.projectmanagement.service;

import com.sda.projectmanagement.persistence.UsersEntity;
import com.sda.projectmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(UsersEntity newUser) {
        userRepository.save(newUser);
    }

    public List<UsersEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public void editUser(UsersEntity editedUser) {
        userRepository.save(editedUser);
    }

    public void deleteUser(UsersEntity projectEntity) {
        userRepository.deleteById(projectEntity.getUserId());
    }
}
