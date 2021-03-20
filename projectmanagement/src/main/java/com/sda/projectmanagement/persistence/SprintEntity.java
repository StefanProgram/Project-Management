package com.sda.projectmanagement.persistence;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class SprintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Date dateFrom;
    private Date dateTo;
    private Integer plannedStoryPoints;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Date getDatefrom() {
        return dateFrom;
    }

    public void setDatefrom(Date datefrom) {
        this.dateFrom = datefrom;
    }

    public Date getDateto() {
        return dateTo;
    }

    public void setDateto(Date dateto) {
        this.dateTo = dateto;
    }

    public Integer getPlannedstorypoints() {
        return plannedStoryPoints;
    }

    public void setPlannedstorypoints(Integer plannedstorypoints) {
        this.plannedStoryPoints = plannedstorypoints;
    }
}
