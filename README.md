## --Spring Boot Task Management System--

This project was developed to function the basic CRUD operations of a Task Management System.

## Build
* Spring Boot version: 2.7.8
* Java version: 8
* Database: MySQL
* Mvn Dependencies:
    	Spring Web
    	Spring Data Jpa
    	MySQL driver
    	Lombok
    	Swagger 2.9.2
    	Mapstruct 1.4.2

## Database Structure
* Entities: 
    *Admin
    *User
    *Task
* Entity relationships:
    *One to many relationship between user and task.

## Notes: 
* There is only one admin and admin can manage (CRUD) users and tasks.
* you should add admin name as "SYSTEM" and set any password manually to the admin table at database.
* Users are added by the admin.
