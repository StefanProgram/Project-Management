package com.sda.projectmanagement.persistence;

import javax.persistence.*;

@Entity
@Table(name = "participationintheproject")
public class ParticipationInProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer participationId;

    @OneToOne
    private ProjectsEntity projectsEntity;

    @OneToOne
    private UsersEntity usersEntity;

    public Integer getParticipationId() {
        return participationId;
    }

    public void setParticipationId(Integer participationId) {
        this.participationId = participationId;
    }

    public ProjectsEntity getProjectsEntity() {
        return projectsEntity;
    }

    public void setProjectsEntity(ProjectsEntity projectsEntity) {
        this.projectsEntity = projectsEntity;
    }

    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    public ProjectsEntity getProjectEntity() {
        return projectsEntity;
    }

    public void setProjectEntity(ProjectsEntity projectsEntity) {
        this.projectsEntity = projectsEntity;
    }

    public UsersEntity getUserEntity() {
        return usersEntity;
    }

    public void setUserEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

}
