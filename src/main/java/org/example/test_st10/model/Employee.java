package org.example.test_st10.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String department;
    private Double salary;
}
