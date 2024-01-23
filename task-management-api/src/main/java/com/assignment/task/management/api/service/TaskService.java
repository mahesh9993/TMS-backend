package com.assignment.task.management.api.service;

import com.assignment.task.management.api.dto.TaskDTO;
import com.assignment.task.management.api.dto.request.TaskUpdateRQ;
import com.assignment.task.management.api.dto.request.TaskUpdateUserRQ;
import com.assignment.task.management.api.dto.response.TaskResponseDTO;

import java.util.List;

public interface TaskService {
    String addTask(TaskUpdateRQ taskUpdateRQ);

    List<TaskResponseDTO> getAllTasks();

    String updateTask(TaskUpdateRQ taskUpdateRQ);

    String deleteTask(int id);

    TaskResponseDTO getTaskById(int id);

//    List<TaskResponseDTO> getTasksByPriority(PriorityLevel priority);
//
//    List<TaskResponseDTO> getTasksByStatus(Status status);

    List<TaskResponseDTO> getTasksByUser(int id);

    String updateTaskByUser(int id, TaskUpdateUserRQ taskUpdateUserRQ);
}
