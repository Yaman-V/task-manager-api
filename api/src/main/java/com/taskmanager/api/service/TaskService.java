package com.taskmanager.api.service;

import com.taskmanager.api.dto.TaskRequestDTO;
import com.taskmanager.api.dto.TaskResponseDTO;
import com.taskmanager.api.entity.Task;
import com.taskmanager.api.mapper.TaskMapper;
import com.taskmanager.api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toTaskResponseDTO)
                .toList();
    }

    public Optional<TaskResponseDTO> getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(taskMapper::toTaskResponseDTO); // Here Optional.map() not the same as Stream().map()
    }

    public TaskResponseDTO addTask(TaskRequestDTO dto) {
        Task saved = taskRepository.save(taskMapper.toTask(dto));
        return taskMapper.toTaskResponseDTO(saved);
    }

    public Optional<TaskResponseDTO> updateTask(Long id, TaskRequestDTO dto) {
        return taskRepository.findById(id).map(existing -> {
            existing.setTitle(dto.title());
            existing.setDescription(dto.description());
            existing.setStatus(dto.status());
            return taskMapper.toTaskResponseDTO(taskRepository.save(existing));
        });
    }

    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}