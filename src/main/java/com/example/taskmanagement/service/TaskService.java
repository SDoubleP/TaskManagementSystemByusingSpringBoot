package com.example.taskmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.exception.TaskException;
import com.example.taskmanagement.repository.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    
    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    
    public List<Task> checkAll(){
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task taskDetails){
        Task task = taskRepository.findById(id).orElseThrow(()-> new TaskException("No such Id : "+ id));
        task.setTitle(taskDetails.getTitle());
        task.setDate(taskDetails.getDate());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());
        return taskRepository.save(task);
        
    }

    public void deleteTask(Long id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new TaskException("No such id : "+id));
        taskRepository.deleteById(id);
    }
}
