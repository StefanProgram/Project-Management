package com.sda.projectmanagement.service;

import com.sda.projectmanagement.persistence.ProjectsEntity;
import com.sda.projectmanagement.persistence.UsersEntity;
import com.sda.projectmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<UsersEntity> userOptional = userRepository.findByLogin(s);
        if (userOptional.isPresent()) {
            UsersEntity user = userOptional.get();
            String login = user.getLogin();
            String password = user.getPassword();
            List<GrantedAuthority> roleList = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
            UserDetails userDetails = new User(login, password, roleList);
            return userDetails;
        }

        throw new UsernameNotFoundException("User login not found!");
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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

    public UsersEntity getUserByEmail(String email) {
        UsersEntity usersEntity = userRepository.findByEmail(email);
        return usersEntity;
    }

    public void register(UsersEntity user) {
        user.setRole("ROLE_USER");
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public UsersEntity getUserByUsername(String login) {
        Optional<UsersEntity> userOptional = userRepository.findByLogin(login);
        return userOptional.get();
    }
}
