package com.taskmanager.api.repository;

import com.taskmanager.api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
