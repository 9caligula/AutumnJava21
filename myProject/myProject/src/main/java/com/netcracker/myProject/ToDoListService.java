package com.netcracker.myProject;

import com.netcracker.myProject.model.ToDoList;
import com.netcracker.myProject.repos.ToDoListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ToDoListService {
    private final ToDoListRepo toDoListRepo;

    @Autowired
    public ToDoListService(ToDoListRepo toDoListRepo) {
        this.toDoListRepo = toDoListRepo;
    }

    public ToDoList addTask(ToDoList toDoList) {
        return toDoListRepo.save(toDoList);
    }

    public ToDoList updateTask(ToDoList toDoList) {
        ToDoList newToDoList = toDoListRepo.findById(toDoList.getId()).orElseThrow();
        newToDoList.setDate(toDoList.getDate());
        newToDoList.setThing(toDoList.getThing());
        return toDoListRepo.save(newToDoList);
    }

    public List<ToDoList> getAllTasks() {
        return toDoListRepo.findAll();
    }

    public void deleteTask(Long id) {
        toDoListRepo.deleteById(id);
    }
}