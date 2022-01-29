package com.netcracker.myProject.controller;

import com.netcracker.myProject.entity.ParameterEntity;
import com.netcracker.myProject.service.ParameterService;
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
public class ParameterController {

    ParameterService service;

    public static final String GET_ALL_PARAMETERS = "/parameter";
    public static final String CREATE_PARAMETERS = "/object/{objectId}/attribute/{attributeId}/{value}";
    public static final String DELETE_PARAMETER = "/parameter/delete/{id}";

    @GetMapping(GET_ALL_PARAMETERS)
    public ResponseEntity<List<ParameterEntity>> getAllParameters() {
        List<ParameterEntity> list = service.getAllParameters();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(CREATE_PARAMETERS)
    public ResponseEntity<ParameterEntity> createParameter(@PathVariable Long objectId,
            @PathVariable Long attributeId, @PathVariable String value) {

        ParameterEntity parameterEntity = service.createParameter(value, objectId, attributeId);
        return new ResponseEntity<>(parameterEntity, HttpStatus.CREATED);
    }

    @DeleteMapping(DELETE_PARAMETER)
    public ResponseEntity<?> deleteParameter(@PathVariable Long id) {
        service.deleteParameter(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}