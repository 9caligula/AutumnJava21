package com.netcracker.myProject.model;

import javax.persistence.*;

@Entity
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String date;
    private String thing;

    public ToDoList() { }

    public ToDoList(String date, String thing) {
        this.date = date;
        this.thing = thing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }
}