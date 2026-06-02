package com.taskmanager.api.dto;

import jakarta.validation.constraints.NotBlank;
import com.taskmanager.api.entity.Task;
import jakarta.validation.constraints.NotNull;

public record TaskRequestDTO(@NotBlank String title , String description ,@NotNull Task.Status status) {
}
