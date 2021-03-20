package com.sda.projectmanagement.persistence;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class ProjectsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    private String name;
    private String description;

    @OneToOne
    @JoinColumn(name = "login")
    private UsersEntity administrator;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UsersEntity getAdministrator() {
        return administrator;
    }

    public void setAdministrator(UsersEntity administrator) {
        this.administrator = administrator;
    }

    @Override
    public String toString() {
        return "ProjectsEntity{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", administrator=" + administrator +
                '}';
    }
}
