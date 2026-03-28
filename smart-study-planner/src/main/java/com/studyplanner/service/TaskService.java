package com.studyplanner.service;

import com.studyplanner.entity.Task;
import com.studyplanner.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Task save(Task task) {
        task.setStatus("Pending"); 
        return repo.save(task);
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }  

    public Task markComplete(Long id) {
    Task task = repo.findById(id).orElseThrow();
    task.setStatus("Completed");
    return repo.save(task);
}
}