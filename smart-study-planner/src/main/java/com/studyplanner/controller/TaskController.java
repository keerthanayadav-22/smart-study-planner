package com.studyplanner.controller;

import com.studyplanner.entity.Task;
import com.studyplanner.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.save(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}/complete")
    public Task markComplete(@PathVariable Long id) {
        return service.markComplete(id);
    }
}
