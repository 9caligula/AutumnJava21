package com.netcracker.myProject.repository;

import com.netcracker.myProject.entity.ObjectTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectTypeRepository extends JpaRepository<ObjectTypeEntity, Long> {
    @Query(value = "select case when count(name) > 0 " +
            "then true else false end from object_type name where name = ?1", nativeQuery = true)
    Boolean existByName(@Param("name") String name);
}