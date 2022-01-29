package com.netcracker.myProject.service;

import com.netcracker.myProject.entity.AttributeEntity;
import com.netcracker.myProject.entity.ObjectTypeEntity;
import com.netcracker.myProject.exception.NotFoundException;
import com.netcracker.myProject.repository.AttributeRepository;
import com.netcracker.myProject.repository.ObjectTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AttributeService {

    AttributeRepository repository;
    ObjectTypeRepository objectTypeRepository;

    public List<AttributeEntity> getAllAttribute() {
        return repository.findAll();
    }

    public List<AttributeEntity> getAttributeByID(Long id) {
        return repository.findAll().stream()
                .filter(attr -> attr.getObjectType().getId().equals(id))
                .collect(Collectors.toList());
    }

    public AttributeEntity createAttribute(Long id, String name) {
        ObjectTypeEntity objectTypeEntity = objectTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("This type was not found"));

        return repository.saveAndFlush(AttributeEntity.makeDefault(objectTypeEntity, name));
    }

    public void deleteAttribute(Long id) {
        repository.deleteById(id);
    }
}