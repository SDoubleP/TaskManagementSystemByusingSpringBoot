package com.example.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.service.TaskService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getalltasks(){
        return taskService.checkAll();
    }

    @PutMapping("{id}")
    public Task updateTask(@PathVariable("id") Long id,@RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("{id}")
    public void deletebyId(@PathVariable("id") Long id){
        taskService.deleteTask(id);
    }
}
