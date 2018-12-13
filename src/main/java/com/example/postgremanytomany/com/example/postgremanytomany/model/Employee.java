package com.example.postgremanytomany.com.example.postgremanytomany.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Employee")
public class Employee extends DateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employee_id;

    @NotNull
    @Column(length = 100)
    private String firstName;

    @NotNull
    @Column(length = 255)
    private String lastName;

    @NotNull
    private String employeeDept;


    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "employee_project",joinColumns =
            {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private Set<Project> projects = new HashSet<>();


    public Employee() {
    }

    public Employee(@NotNull String firstName, @NotNull String lastName, @NotNull String employeeDept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeDept = employeeDept;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeDept() {
        return employeeDept;
    }

    public void setEmployeeDept(String employeeDept) {
        this.employeeDept = employeeDept;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return getEmployee_id() == employee.getEmployee_id() &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName()) &&
                Objects.equals(getEmployeeDept(), employee.getEmployeeDept()) &&
                Objects.equals(getProjects(), employee.getProjects());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEmployee_id(), getFirstName(), getLastName(), getEmployeeDept(), getProjects());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeDept='" + employeeDept + '\'' +
                ", projects=" + projects +
                '}';
    }
}
