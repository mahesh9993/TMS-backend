package com.assignment.task.management.api.advisor;

import com.assignment.task.management.api.exception.NotFoundException;
import com.assignment.task.management.api.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AppWiseExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> notFoundExceptionHandler(NotFoundException ex){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"ERROR",ex.getMessage()), HttpStatus.NOT_FOUND
        );
    }

}
