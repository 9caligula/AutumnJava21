package com.netcracker.myProject.controller;

import com.netcracker.myProject.entity.ObjectTypeEntity;
import com.netcracker.myProject.service.ObjectTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
public class ObjectTypeController {

    ObjectTypeService objectTypeService;

    public static final String GET_TYPE = "/type";
    public static final String GET_NAMES = "/type/names";
    public static final String GET_TYPE_BY_ID = "/type/{id}";
    public static final String GET_CHILD_TYPE = "/type/child/{id}";
    public static final String CREATE_TYPE = "/type/{nameTypeObject}";
    public static final String CREATE_TYPE_WITH_PARENT = "/type/{nameTypeObject}/{parentId}";
    public static final String DELETE_TYPE = "/type/delete/{id}";

    @GetMapping(GET_TYPE)
    public ResponseEntity<List<ObjectTypeEntity>> getObjectTypes() {
        List<ObjectTypeEntity> list = objectTypeService.getAllType();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(GET_NAMES)
    public ResponseEntity<List<String>> getObjectTypesByName() {
        List<String> list = objectTypeService.getNamesOfAllTypes();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(GET_TYPE_BY_ID)
    public ResponseEntity<ObjectTypeEntity> getObjectTypeById(@PathVariable Long id) {
        ObjectTypeEntity objectType = objectTypeService.getObjectTypeById(id);
        return new ResponseEntity<>(objectType, HttpStatus.OK);
    }

    @GetMapping(GET_CHILD_TYPE)
    public ResponseEntity<List<ObjectTypeEntity>> getChildObjectType(@PathVariable Long id) {
        List<ObjectTypeEntity> list = objectTypeService.getChildObjectType(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(CREATE_TYPE)
    public ResponseEntity<ObjectTypeEntity> createObjectType(@PathVariable String nameTypeObject) {
        ObjectTypeEntity type = objectTypeService.createObjectType(nameTypeObject);
        return new ResponseEntity<>(type, HttpStatus.CREATED);
    }

    @PostMapping(CREATE_TYPE_WITH_PARENT)
    public ResponseEntity<ObjectTypeEntity> createObjectTypeWithParent(@PathVariable String nameTypeObject,
                                                                       @PathVariable Long parentId) {
        ObjectTypeEntity type = objectTypeService.createObjectTypeWithParent(nameTypeObject, parentId);
        return new ResponseEntity<>(type, HttpStatus.CREATED);
    }

    @DeleteMapping(DELETE_TYPE)
    public ResponseEntity<?> deleteObjectType(@PathVariable Long id) {
        objectTypeService.deleteType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}