package com.covidmonitor.repository;

import org.springframework.data.repository.CrudRepository;
import com.covidmonitor.model.Role;

public interface RoleRepo extends CrudRepository<Role, Long>{
    
}
