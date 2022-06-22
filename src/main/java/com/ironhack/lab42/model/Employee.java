package com.ironhack.lab42.model;

import com.ironhack.lab42.enums.Status;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;
    private String department;
    @Column(name = "employee_name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_employee")
    private Status status;
    public Employee() {
    }

    public Employee(String department, String name, Status status) {
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}