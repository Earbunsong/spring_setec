package org.example.test_st10.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String sex;
    private String email;
    private int score;
    private int age;

    private LocalDateTime createdAt = LocalDateTime.now();


   /* private Long id;
    private String name;
    private String sex;
    private String email;
    private int score;

    public Students() {}

    public Students(Long id, String name, String sex, String email, int score) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.score = score;
    }

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }*/
}
