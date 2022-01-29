package com.netcracker.myProject.service;

import com.netcracker.myProject.entity.AttributeEntity;
import com.netcracker.myProject.entity.LinkEntity;
import com.netcracker.myProject.entity.ObjectEntity;
import com.netcracker.myProject.exception.NotFoundException;
import com.netcracker.myProject.repository.AttributeRepository;
import com.netcracker.myProject.repository.LinkRepository;
import com.netcracker.myProject.repository.ObjectRepository;
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
public class LinkService {

    LinkRepository linkRepository;
    ObjectRepository objectRepository;
    AttributeRepository attributeRepository;

    public List<LinkEntity> getAllLinks() {
        return linkRepository.findAll();
    }

    public LinkEntity createLink(Long objectId, Long refId, Long attrId) {
        ObjectEntity object = objectRepository.findById(objectId)
                .orElseThrow(() -> new NotFoundException("This object was not found"));

        ObjectEntity reference = objectRepository.findById(refId)
                .orElseThrow(() -> new NotFoundException("This object was not found"));

        AttributeEntity attribute = attributeRepository.findById(attrId)
                .orElseThrow(() -> new NotFoundException("This attribute was not found"));

        return linkRepository.saveAndFlush(LinkEntity.makeDefault(object, reference, attribute));
    }

    public void deleteLink(Long id) {
        linkRepository.deleteById(id);
    }
}