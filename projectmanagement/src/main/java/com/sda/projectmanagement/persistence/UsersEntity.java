package com.sda.projectmanagement.persistence;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String login;
    private String password;
    private String email;
    private String displayedName;

    @OneToOne(mappedBy = "administrator")
    private ProjectsEntity projectsEntity;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayedName() {
        return displayedName;
    }

    public void setDisplayedName(String displayedName) {
        this.displayedName = displayedName;
    }

    public ProjectsEntity getProjectsEntity() {
        return projectsEntity;
    }

    public void setProjectsEntity(ProjectsEntity projectsEntity) {
        this.projectsEntity = projectsEntity;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", displayedName='" + displayedName + '\'' +
                ", projectsEntity=" + projectsEntity +
                '}';
    }
}
