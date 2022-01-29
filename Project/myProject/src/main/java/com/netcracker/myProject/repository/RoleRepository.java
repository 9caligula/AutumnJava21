package com.netcracker.myProject.repository;

import com.netcracker.myProject.entity.ERole;
import com.netcracker.myProject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}