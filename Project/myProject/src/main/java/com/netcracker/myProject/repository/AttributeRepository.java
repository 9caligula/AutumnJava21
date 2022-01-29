package com.netcracker.myProject.repository;

import com.netcracker.myProject.entity.AttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<AttributeEntity, Long> {

}