package com.netcracker.myProject.controller;

import com.netcracker.myProject.entity.LinkEntity;
import com.netcracker.myProject.service.LinkService;
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
public class LinkController {

    LinkService service;

    public static final String GET_ALL_LINK = "/link";
    public static final String CREATE_LINK = "/link/{objectId}/attribute/{attributeId}/reference/{referenceId}";
    public static final String DELETE_LINK = "/link/delete/{id}";

    @GetMapping(GET_ALL_LINK)
    public ResponseEntity<List<LinkEntity>> getAllLinks() {
        List<LinkEntity> list = service.getAllLinks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(CREATE_LINK)
    public ResponseEntity<LinkEntity> createLink(@PathVariable Long objectId, @PathVariable Long attributeId,
                                                 @PathVariable Long referenceId) {

        LinkEntity linkEntity = service.createLink(objectId, referenceId, attributeId);
        return new ResponseEntity<>(linkEntity, HttpStatus.CREATED);
    }

    @DeleteMapping(DELETE_LINK)
    public ResponseEntity<?> deleteLink(@PathVariable Long id) {
        service.deleteLink(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}