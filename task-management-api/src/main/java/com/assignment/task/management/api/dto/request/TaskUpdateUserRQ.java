package com.assignment.task.management.api.dto.request;
import com.assignment.task.management.api.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskUpdateUserRQ {

    private Status status;
}
