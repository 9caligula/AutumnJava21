package com.netcracker.myProject.repository;

import com.netcracker.myProject.entity.ObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends JpaRepository<ObjectEntity, Long> {

}