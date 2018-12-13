package com.example.postgremanytomany.com.example.postgremanytomany.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.EntityListeners;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonIgnoreProperties(value = {"createdDate","updatedDate"},allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public abstract class DateModel implements Serializable {


    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateModel)) return false;
        DateModel dateModel = (DateModel) o;
        return Objects.equals(getCreatedDate(), dateModel.getCreatedDate()) &&
                Objects.equals(getUpdatedDate(), dateModel.getUpdatedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreatedDate(), getUpdatedDate());
    }

    @Override
    public String toString() {
        return "DateModel{" +
                "createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
