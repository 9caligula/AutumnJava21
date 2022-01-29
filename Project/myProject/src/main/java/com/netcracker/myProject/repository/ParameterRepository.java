package com.netcracker.myProject.repository;

import com.netcracker.myProject.entity.ParameterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<ParameterEntity, Long> {

}