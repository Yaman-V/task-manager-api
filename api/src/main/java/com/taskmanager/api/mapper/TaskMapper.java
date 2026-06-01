package com.taskmanager.api.mapper;

import com.taskmanager.api.dto.TaskRequestDTO;
import com.taskmanager.api.dto.TaskResponseDTO;
import com.taskmanager.api.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task toTask(TaskRequestDTO taskRequestDTO) {
        return new Task(
                taskRequestDTO.title(),
                taskRequestDTO.description(),
                taskRequestDTO.status()
        );
    }

    public TaskResponseDTO toTaskResponseDTO(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus()
        );
    }
}