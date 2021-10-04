package com.covidmonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import roles.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}