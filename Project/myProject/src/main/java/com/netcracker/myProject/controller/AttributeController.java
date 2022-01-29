package com.netcracker.myProject.controller;

import com.netcracker.myProject.entity.AttributeEntity;
import com.netcracker.myProject.service.AttributeService;
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
public class AttributeController {

    AttributeService service;

    public static final String GET_ALL_ATTRIBUTE = "/attribute";
    public static final String GET_ATTRIBUTE_BY_ID = "/attribute/{objectId}";
    public static final String CREATE_ATTRIBUTE = "/type/attribute/{objectId}/{name}";
    public static final String DELETE_ATTRIBUTE = "/attribute/delete/{id}";

    @GetMapping(GET_ALL_ATTRIBUTE)
    public ResponseEntity<List<AttributeEntity>> getAllAttribute() {
        List<AttributeEntity> list = service.getAllAttribute();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(GET_ATTRIBUTE_BY_ID)
    public ResponseEntity<List<AttributeEntity>> getAttributeByID(@PathVariable Long objectId) {
        List<AttributeEntity> list = service.getAttributeByID(objectId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(CREATE_ATTRIBUTE)
    public ResponseEntity<AttributeEntity> createAttribute(@PathVariable Long objectId, @PathVariable String name) {
        AttributeEntity attribute = service.createAttribute(objectId, name);
        return new ResponseEntity<>(attribute, HttpStatus.CREATED);
    }

    @DeleteMapping(DELETE_ATTRIBUTE)
    public ResponseEntity<?> deleteAttribute(@PathVariable Long id) {
        service.deleteAttribute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}