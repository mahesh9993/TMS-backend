package com.assignment.task.management.api.controller;
import com.assignment.task.management.api.dto.TaskDTO;
import com.assignment.task.management.api.dto.request.TaskUpdateRQ;
import com.assignment.task.management.api.dto.request.TaskUpdateUserRQ;
import com.assignment.task.management.api.dto.response.TaskResponseDTO;
import com.assignment.task.management.api.service.TaskService;
import com.assignment.task.management.api.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<StandardResponse> addTask(@RequestBody TaskUpdateRQ taskUpdateRQ){
        String response = this.taskService.addTask(taskUpdateRQ);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Task Added",response), HttpStatus.CREATED
        );
    }

    @GetMapping("/tasks")
    public ResponseEntity<StandardResponse> getAllTasks(){
        List<TaskResponseDTO> taskDTOList = this.taskService.getAllTasks();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All Tasks",taskDTOList), HttpStatus.OK
        );
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<StandardResponse> getTaskById(@PathVariable(value = "id") int id){
        TaskResponseDTO taskResponseDTO = this.taskService.getTaskById(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Task Details",taskResponseDTO), HttpStatus.OK
        );
    }

   @PutMapping("/tasks")
    public ResponseEntity<StandardResponse> updateTask(@RequestBody TaskUpdateRQ taskUpdateRQ){
        String response = this.taskService.updateTask(taskUpdateRQ);
       return new ResponseEntity<StandardResponse>(
               new StandardResponse(200,"Task Updated",response), HttpStatus.OK
       );
   }

   @PutMapping("/tasks/user/{id}")
   public ResponseEntity<StandardResponse> updateTaskByUser(@PathVariable(value = "id") int id,
                                                            @RequestBody TaskUpdateUserRQ taskUpdateUserRQ){
        String response = this.taskService.updateTaskByUser(id, taskUpdateUserRQ);
       return new ResponseEntity<StandardResponse>(
               new StandardResponse(200,"Task Updated",response), HttpStatus.OK
       );
   }


   @DeleteMapping("/tasks/{id}")
    public ResponseEntity<StandardResponse> deleteTask(@PathVariable(value = "id")  int id){
        String response = this.taskService.deleteTask(id);
       return new ResponseEntity<StandardResponse>(
               new StandardResponse(200,"Task Deleted",response), HttpStatus.OK
       );
   }

//   @GetMapping(
//           path = "/tasks/priority",
//           params = {"priority"}
//   )
//   public ResponseEntity<StandardResponse> getTasksByPriority(@RequestParam(value = "priority") PriorityLevel priority){
//        List<TaskResponseDTO> taskDTOS = this.taskService.getTasksByPriority(priority);
//       return new ResponseEntity<StandardResponse>(
//               new StandardResponse(200,"Task List by Priority",taskDTOS), HttpStatus.OK
//       );
//   }

//   @GetMapping(
//           path = "/tasks/status",
//           params = {"status"}
//   )
//   public ResponseEntity<StandardResponse> getTasksByStatus(@RequestParam(value = "status") Status status){
//       List<TaskResponseDTO> taskDTOS = this.taskService.getTasksByStatus(status);
//       return new ResponseEntity<StandardResponse>(
//               new StandardResponse(200,"Task List by Status",taskDTOS), HttpStatus.OK
//       );
//   }

   @GetMapping("/tasks/user/{id}")
    public ResponseEntity<StandardResponse> getTasksByUser (@PathVariable(value = "id") int id){
        List<TaskResponseDTO> taskResponseDTOS = this.taskService.getTasksByUser(id);
       return new ResponseEntity<StandardResponse>(
               new StandardResponse(200,"Task List by User",taskResponseDTOS), HttpStatus.OK
       );
   }

}
