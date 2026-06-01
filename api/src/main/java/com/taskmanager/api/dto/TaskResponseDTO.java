package com.taskmanager.api.dto;

import com.taskmanager.api.entity.Task;

public record TaskResponseDTO(Long id, String title , String description , Task.Status status) {
}
