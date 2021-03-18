package com.app.repository;

import com.app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Integer, Long> {
    Role findByRole(String role);
}
