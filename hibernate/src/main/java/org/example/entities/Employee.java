package org.example.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "employee_name")
    private String name;
    @Column (name = "employee_surname")
    private String surname;
    @Column (name = "employee_gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column (name = "employee_job")
    @Enumerated(EnumType.STRING)
    private Job job;
    @Column (name = "employee_creationdate")
    @CreationTimestamp
    private Date creationDate;
    @Column (name = "employee_lastmodifieddate")
    @UpdateTimestamp
    private Date  lastModifiedDate;

    public Employee(String name, String surname, Gender gender, Job job) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.job = job;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Date  getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date  creationDate) {
        this.creationDate = creationDate;
    }

    public Date  getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date  lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
