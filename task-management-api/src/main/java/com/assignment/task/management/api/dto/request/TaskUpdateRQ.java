package com.assignment.task.management.api.dto.request;

import com.assignment.task.management.api.model.enums.PriorityLevel;
import com.assignment.task.management.api.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskUpdateRQ {
    private int taskId;

    private int userId;

    private String taskName;

    private PriorityLevel priorityLevel;

    private Status status;
}
