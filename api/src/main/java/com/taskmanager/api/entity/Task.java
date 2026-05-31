package com.taskmanager.api.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Task {

    public enum Status {
        TODO,
        IN_PROGRESS,
        DONE,
        SUSPENDED
    }

    @Id // Assigning id as a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This takes care of generating the "id"
    private Long id;

    @Column
    private String description;

    @Column(nullable = false)
    private String title;

    // the JPA deal with the enum as a string not as positions (0,1,2)
    // so when I change the positions the DB does not get corrupted.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    // The JPA MUST have a no-argument constructor and it can be empty.
    protected Task() {
    }

    public Task(String title, String description, Status status) {
        this.title = Objects.requireNonNull(title, "title must not be null");
        this.description = (description != null) ? description : "";
        this.status = (status != null) ? status : Status.TODO;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = Objects.requireNonNull(title, "title must not be null");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = (description != null) ? description : "";
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = Objects.requireNonNull(status, "status must not be null");
    }
}