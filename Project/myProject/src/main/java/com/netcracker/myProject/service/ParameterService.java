package com.netcracker.myProject.service;

import com.netcracker.myProject.entity.AttributeEntity;
import com.netcracker.myProject.entity.ObjectEntity;
import com.netcracker.myProject.entity.ObjectTypeEntity;
import com.netcracker.myProject.entity.ParameterEntity;
import com.netcracker.myProject.exception.NotFoundException;
import com.netcracker.myProject.repository.AttributeRepository;
import com.netcracker.myProject.repository.ObjectRepository;
import com.netcracker.myProject.repository.ObjectTypeRepository;
import com.netcracker.myProject.repository.ParameterRepository;
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
public class ParameterService {

    ParameterRepository parameterRepository;
    ObjectRepository objectRepository;
    AttributeRepository attributeRepository;

    public List<ParameterEntity> getAllParameters() {
        return parameterRepository.findAll();
    }

    public ParameterEntity createParameter(String value, Long objectId, Long attrId) {
        ObjectEntity object = objectRepository.findById(objectId)
                .orElseThrow(() -> new NotFoundException("This type was not found"));

        AttributeEntity attribute = attributeRepository.findById(attrId)
                .orElseThrow(() -> new NotFoundException("This type was not found"));

        return parameterRepository.saveAndFlush(ParameterEntity.makeDefault(object, attribute, value));
    }

    public void deleteParameter(Long id) {
        parameterRepository.deleteById(id);
    }
}