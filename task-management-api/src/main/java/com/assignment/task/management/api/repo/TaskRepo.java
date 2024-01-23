package com.assignment.task.management.api.repo;
import com.assignment.task.management.api.model.Task;
import com.assignment.task.management.api.model.User;
import com.assignment.task.management.api.model.enums.PriorityLevel;
import com.assignment.task.management.api.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task,Integer> {
    List<Task> findAllByPriorityLevelEquals(PriorityLevel priority);

    List<Task> findAllByStatusEquals(Status status);

    List<Task> findAllByUserEquals (User user);
}
