package com.netcracker.myProject.repos;

import com.netcracker.myProject.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepo extends JpaRepository<ToDoList, Long> {

}
