package com.covidmonitor.controller;

import com.covidmonitor.model.Role;
import com.covidmonitor.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RoleController {
    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/api/roles")
    public List<Role> getRole(){
        List<Role> role = new ArrayList<>();
        roleRepo.findAll().forEach(role::add);
        return role;
    }

    @GetMapping("/api/roles/{id}")
    public Role getRole(@PathVariable long id) {
        Optional<Role> retorno = roleRepo.findById(id);
        Role role = null;
        if(retorno.isPresent()) {
            role = retorno.get();
        }
        return role;
    }

    @PostMapping("/api/roles")
    public Role createRole(@RequestBody Role role) {
    	roleRepo.save(role);
        return role;
    }

    @PutMapping("/api/roles/{id}")
    public Role updateRole(@RequestBody Role a, @PathVariable long id) {
        Role role = null;
    	role = this.getRole(id);
        if(role != null) {
            roleRepo.save(a);
            role = a;
        }
        return a;
    }

    @DeleteMapping(value = "/api/roles{id}", produces = "application/json")
    public String deleteRole(@PathVariable long id) {
        Role role = this.getRole(id);
        boolean result = false;
        if(role != null) {
        	roleRepo.delete(role);
            result = true;
        }
        return "{ \"sucess\" : " + (result ? "true" : "false" ) + " }";
    }
	
}
