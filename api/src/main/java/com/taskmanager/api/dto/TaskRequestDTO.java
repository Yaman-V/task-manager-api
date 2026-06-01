package com.taskmanager.api.dto;

import com.taskmanager.api.entity.Task;

public record TaskRequestDTO(String title , String description , Task.Status status) {
}
