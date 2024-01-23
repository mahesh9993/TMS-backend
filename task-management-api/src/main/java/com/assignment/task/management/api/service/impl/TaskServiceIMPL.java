package com.assignment.task.management.api.service.impl;
import com.assignment.task.management.api.dto.TaskDTO;
import com.assignment.task.management.api.dto.request.TaskUpdateRQ;
import com.assignment.task.management.api.dto.request.TaskUpdateUserRQ;
import com.assignment.task.management.api.dto.response.TaskResponseDTO;
import com.assignment.task.management.api.exception.NotFoundException;
import com.assignment.task.management.api.model.Task;
import com.assignment.task.management.api.model.User;
import com.assignment.task.management.api.repo.TaskRepo;
import com.assignment.task.management.api.repo.UserRepo;
import com.assignment.task.management.api.service.TaskService;
import com.assignment.task.management.api.util.mappers.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceIMPL implements TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private UserRepo userRepo;


    @Override
    public String addTask(TaskUpdateRQ taskDto) {
        if (this.userRepo.existsById(taskDto.getUserId())){
            User user = this.userRepo.getReferenceById(taskDto.getUserId());
            Task task = new Task();

            task.setTaskName(taskDto.getTaskName());
            task.setPriorityLevel(taskDto.getPriorityLevel());
            task.setStatus(taskDto.getStatus());
            task.setUser(user);

            this.taskRepo.save(task);

            return task.getTaskName();
        }else{
            throw new NotFoundException("User Not found for Assign the Task");
        }

    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
        List<Task> taskList = this.taskRepo.findAll();
        if (taskList.size()>0) {
            List<TaskResponseDTO> taskDTOList = new ArrayList<TaskResponseDTO>();

            for (Task task: taskList) {
                TaskResponseDTO taskResponseDTO = new TaskResponseDTO();

                taskResponseDTO.setUserName(task.getUser().getUserName());
                taskResponseDTO.setUserId(task.getUser().getUserId());
                taskResponseDTO.setTaskId(task.getTaskId());
                taskResponseDTO.setTaskName(task.getTaskName());
                taskResponseDTO.setStatus(task.getStatus());
                taskResponseDTO.setPriorityLevel(task.getPriorityLevel());

                taskDTOList.add(taskResponseDTO);
            }
            return taskDTOList;
        }else {
            throw new NotFoundException("Tasks not found");
        }
    }

    @Override
    public TaskResponseDTO getTaskById(int id) {
        if (this.taskRepo.existsById(id)){
            Task task = this.taskRepo.getReferenceById(id);
            TaskResponseDTO taskResponseDTO = new TaskResponseDTO();

            taskResponseDTO.setUserId(task.getUser().getUserId());
            taskResponseDTO.setTaskId(task.getTaskId());
            taskResponseDTO.setTaskName(task.getTaskName());
            taskResponseDTO.setPriorityLevel(task.getPriorityLevel());
            taskResponseDTO.setStatus(task.getStatus());
            taskResponseDTO.setUserName(task.getUser().getUserName());

            return taskResponseDTO;
        }else {
            throw new NotFoundException("Task Not Found");
        }

    }


    @Override
    public String updateTask(TaskUpdateRQ taskUpdateRQ) {
        if (this.taskRepo.existsById(taskUpdateRQ.getTaskId())){
            Task task = this.taskRepo.getReferenceById(taskUpdateRQ.getTaskId());

            task.setTaskName(taskUpdateRQ.getTaskName());
            task.setPriorityLevel(taskUpdateRQ.getPriorityLevel());
            task.setStatus(taskUpdateRQ.getStatus());
            this.taskRepo.saveAndFlush(task);

            return task.getTaskName();
        }else {
            throw new NotFoundException("Task Not Found For Update");
        }

    }

    @Override
    public String deleteTask(int id) {
        if (this.taskRepo.existsById(id)){
            Task task = this.taskRepo.getReferenceById(id);
            this.taskRepo.deleteById(id);
            return task.getTaskName();
        }else{
            throw new NotFoundException("Task Not Found");
        }

    }

//    @Override
//    public List<TaskResponseDTO> getTasksByPriority(PriorityLevel priority) {
//        List<Task> tasks = this.taskRepo.findAllByPriorityLevelEquals(priority);
//        if (tasks.size()>0){
//
//            List<TaskResponseDTO> taskResponseDTOS = new ArrayList<TaskResponseDTO>();
//
//            for (Task task: tasks) {
//                TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
//
//
//                taskResponseDTO.setTaskId(task.getTaskId());
//                taskResponseDTO.setUserName(task.getUser().getUserName());
//                taskResponseDTO.setTaskName(task.getTaskName());
//                taskResponseDTO.setStatus(task.getStatus());
//                taskResponseDTO.setPriorityLevel(task.getPriorityLevel());
//
//                taskResponseDTOS.add(taskResponseDTO);
//
//            }
//
//            return taskResponseDTOS;
//        }else {
//            throw new NotFoundException("Tasks Not Found");
//        }
//        }


//    @Override
//    public List<TaskResponseDTO> getTasksByStatus(Status status) {
//        List<Task> tasks = this.taskRepo.findAllByStatusEquals(status);
//        List<TaskResponseDTO> taskResponseDTOList = new ArrayList<TaskResponseDTO>();
//        if (tasks.size()>0){
//            for (Task task: tasks) {
//                TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
//
//                taskResponseDTO.setTaskId(task.getTaskId());
//                taskResponseDTO.setUserName(task.getUser().getUserName());
//                taskResponseDTO.setTaskName(task.getTaskName());
//                taskResponseDTO.setStatus(task.getStatus());
//                taskResponseDTO.setPriorityLevel(task.getPriorityLevel());
//
//                taskResponseDTOList.add(taskResponseDTO);
//            }
//            return taskResponseDTOList;
//        }else {
//            throw new NotFoundException("Tasks NOT Found");
//        }
//
//    }

    @Override
    public List<TaskResponseDTO> getTasksByUser(int id) {
        User user = this.userRepo.getReferenceById(id);
        List<Task> tasks = this.taskRepo.findAllByUserEquals(user);
        List<TaskResponseDTO> taskResponseDTOS = new ArrayList<TaskResponseDTO>();

        for (Task task: tasks) {
            TaskResponseDTO taskResponseDTO = new TaskResponseDTO();

            taskResponseDTO.setTaskId(task.getTaskId());
            taskResponseDTO.setUserName(task.getUser().getUserName());
            taskResponseDTO.setUserId(task.getUser().getUserId());
            taskResponseDTO.setTaskName(task.getTaskName());
            taskResponseDTO.setStatus(task.getStatus());
            taskResponseDTO.setPriorityLevel(task.getPriorityLevel());

            taskResponseDTOS.add(taskResponseDTO);
        }
        return taskResponseDTOS;
    }

    @Override
    public String updateTaskByUser(int id, TaskUpdateUserRQ taskUpdateUserRQ) {
        if (this.taskRepo.existsById(id)){
            Task task = this.taskRepo.getReferenceById(id);
            task.setStatus(taskUpdateUserRQ.getStatus());

            this.taskRepo.saveAndFlush(task);
            return task.getStatus().toString();
        }else {
            throw new NotFoundException("Task Not Found");
        }

    }


}
