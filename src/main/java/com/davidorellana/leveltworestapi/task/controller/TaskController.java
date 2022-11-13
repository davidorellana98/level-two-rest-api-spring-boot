package com.davidorellana.leveltworestapi.task.controller;

import com.davidorellana.leveltworestapi.task.data.Task;
import com.davidorellana.leveltworestapi.task.dto.TaskDto;
import com.davidorellana.leveltworestapi.task.service.TaskServiceI;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("v1/tasks")
public class TaskController {

    private final TaskServiceI taskService;

    @Autowired
    public TaskController(TaskServiceI taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Get all tasks")
    @GetMapping
    public ResponseEntity<HashMap<Integer, Task>> allTasks() {
        HashMap<Integer, Task> allTasks = taskService.allTasks();
        if (allTasks.isEmpty()) {
            return new ResponseEntity("There are no task to display :(", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    @Operation(summary = "Create a new Task")
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto) {
        Task task = new Task(taskDto);
        Optional<Task> taskValidation = Optional.ofNullable(taskService.createTask(task));
        if (taskValidation != null) {
            return new ResponseEntity("Created task!", HttpStatus.CREATED);
        }
        return new ResponseEntity("Task not created!", HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "Get a task by its id")
    @GetMapping("/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable("id") Integer idTask) {
        Task task = taskService.findTaskById(idTask);
        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        }
        return new ResponseEntity("That task id does not exist!", HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Update a task by its id")
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Integer idTask, @RequestBody TaskDto taskDto) {
        Task task = new Task(taskDto);
        Task taskUpdated = taskService.updateTask(idTask, task);
        if (taskUpdated != null){
            return new ResponseEntity("Updated task", HttpStatus.OK);
        }else{
            return new ResponseEntity("Task not updated by id not found", HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete a task by its id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTaskById(@PathVariable("id") Integer idTask) {
        Task task = taskService.deleteTaskById(idTask);
        if (task != null) {
            return new ResponseEntity("Task Deleted!", HttpStatus.OK);
        }
        return new ResponseEntity("The task does not exist to be deleted!", HttpStatus.NOT_FOUND);
    }
}
