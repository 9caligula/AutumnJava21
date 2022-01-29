package com.netcracker.myProject.service;

import com.netcracker.myProject.entity.ObjectEntity;
import com.netcracker.myProject.entity.ObjectTypeEntity;
import com.netcracker.myProject.exception.NotFoundException;
import com.netcracker.myProject.repository.ObjectRepository;
import com.netcracker.myProject.repository.ObjectTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ObjectService {

    ObjectRepository objectRepository;
    ObjectTypeRepository objectTypeRepository;

    public List<ObjectEntity> getObjects() {
        return objectRepository.findAll();
    }

    public ObjectEntity createObject(Long id, String name) {
        ObjectTypeEntity objectTypeEntity = objectTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("This type was not found"));

        return objectRepository.saveAndFlush(ObjectEntity.makeDefault(objectTypeEntity, name));
    }

    public void deleteObject(Long id) {
        objectRepository.deleteById(id);
    }
}