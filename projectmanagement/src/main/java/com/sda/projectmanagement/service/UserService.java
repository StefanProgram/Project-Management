package com.sda.projectmanagement.service;

import com.sda.projectmanagement.persistence.ProjectsEntity;
import com.sda.projectmanagement.persistence.UsersEntity;
import com.sda.projectmanagement.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public UsersEntity getUser(Integer id) {
        Optional<UsersEntity> usersEntityOptional = userRepository.findById(id);
        UsersEntity usersEntity = usersEntityOptional.get();
        return usersEntity;
    }
}
