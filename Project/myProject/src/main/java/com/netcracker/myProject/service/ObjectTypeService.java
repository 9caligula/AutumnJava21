package com.netcracker.myProject.service;

import com.netcracker.myProject.entity.ObjectTypeEntity;
import com.netcracker.myProject.exception.BadRequestException;
import com.netcracker.myProject.exception.NotFoundException;
import com.netcracker.myProject.repository.ObjectTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ObjectTypeService {

    ObjectTypeRepository objectTypeRepository;

    public List<ObjectTypeEntity> getAllType() {
        return objectTypeRepository.findAll().stream()
                .filter((type) -> type.getObjectTypeParent() != null)
                .filter((type) -> type.getObjectTypeParent().getObjectTypeParent() == null)
                .collect(Collectors.toList());
    }

    public ObjectTypeEntity createObjectType(String nameObjectType) {
        if (objectTypeRepository.existByName(nameObjectType)) {
            throw new BadRequestException("This type of object already exists");
        }

        ObjectTypeEntity objectType = objectTypeRepository.saveAndFlush(
                ObjectTypeEntity.makeDefault(nameObjectType, null)
        );
        return objectTypeRepository.save(objectType);
    }

    public ObjectTypeEntity createObjectTypeWithParent(String nameObjectType, Long id) {
        if (objectTypeRepository.existByName(nameObjectType)) {
            throw new BadRequestException("This type of object already exists");
        }

        ObjectTypeEntity parent = objectTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(""));

        ObjectTypeEntity objectType = objectTypeRepository.saveAndFlush(
                ObjectTypeEntity.makeDefault(nameObjectType, parent)
        );
        return objectTypeRepository.save(objectType);
    }

    public List<String> getNamesOfAllTypes() {
        return objectTypeRepository.findAll()
                .stream()
                .map(ObjectTypeEntity::getName)
                .collect(Collectors.toList());
    }

    public ObjectTypeEntity getObjectTypeById(Long id) {
        return objectTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("This type was not found"));
    }

    public List<ObjectTypeEntity> getChildObjectType(Long id) {
        return objectTypeRepository.findAll().stream()
                .filter((type) -> type.getObjectTypeParent() != null)
                .filter((type) -> type.getObjectTypeParent().getId().equals(id))
                .collect(Collectors.toList());
    }

    public void deleteType(Long id) {
        objectTypeRepository.deleteById(id);
    }
}