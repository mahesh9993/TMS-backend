package com.assignment.task.management.api.dto;

import com.assignment.task.management.api.model.User;
import com.assignment.task.management.api.model.enums.PriorityLevel;
import com.assignment.task.management.api.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDTO {

    private int taskId;

    private String taskName;

    private User user;

    private PriorityLevel priorityLevel;

    private Status status;
}
