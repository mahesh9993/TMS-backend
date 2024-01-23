package com.assignment.task.management.api.util.mappers;

import com.assignment.task.management.api.dto.TaskDTO;
import com.assignment.task.management.api.dto.request.TaskUpdateRQ;
import com.assignment.task.management.api.model.Task;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface TaskMapper {

    Task taskUpdateRqToTask(TaskUpdateRQ taskUpdateRQ);

    List<TaskDTO> taskListToTaskDtoList(List<Task> taskList);

    TaskDTO taskToTaskDto(Task task);
}
