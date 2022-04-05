package com.joshuamatos.Crud2.employees;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String name;
    LocalDateTime startDate;

    public Employee(long id, String name, LocalDateTime startDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
    }

    public Employee(String name, LocalDateTime startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public Employee() {

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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}