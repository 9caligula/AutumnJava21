package com.netcracker.myProject.controller;

import com.netcracker.myProject.entity.ObjectEntity;
import com.netcracker.myProject.service.ObjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
public class ObjectController {

    ObjectService objectService;

    public static final String FETCH_OBJECT = "/object";
    public static final String CREATE_OBJECT = "/type/object/{id}/{name}";
    public static final String DELETE_OBJECT = "/object/delete/{id}";

    @GetMapping(FETCH_OBJECT)
    public ResponseEntity<List<ObjectEntity>> fetchObject() {
        List<ObjectEntity> list = objectService.getObjects();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(CREATE_OBJECT)
    public ResponseEntity<ObjectEntity> createObject(@PathVariable Long id, @PathVariable String name) {
        ObjectEntity object = objectService.createObject(id, name);
        return new ResponseEntity<>(object, HttpStatus.CREATED);
    }

    @DeleteMapping(DELETE_OBJECT)
    public ResponseEntity<?> deleteObject(@PathVariable Long id) {
        objectService.deleteObject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}