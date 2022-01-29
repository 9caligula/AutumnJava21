package com.netcracker.myProject.controller;

import com.netcracker.myProject.ToDoListService;
import com.netcracker.myProject.model.ToDoList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("tasks")
public class ToDoListController {

    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping("/add")
    public ResponseEntity<ToDoList> addTask(@RequestBody ToDoList toDoList) {
        ToDoList newToDoList = toDoListService.addTask(toDoList);
        return new ResponseEntity<>(newToDoList, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ToDoList> updateTask(@RequestBody ToDoList oldTask) {
        ToDoList newTask = toDoListService.updateTask(oldTask);
        return new ResponseEntity<>(newTask, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ToDoList>> getAllTasks() {
        List<ToDoList> tasks = toDoListService.getAllTasks();
        return new ResponseEntity(tasks, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        toDoListService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}