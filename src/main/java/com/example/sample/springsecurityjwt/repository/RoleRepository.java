package com.example.sample.springsecurityjwt.repository;

import com.example.sample.springsecurityjwt.models.Role;
import com.example.sample.springsecurityjwt.models.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName roleName);
}
