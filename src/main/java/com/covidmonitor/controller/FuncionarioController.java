package com.covidmonitor.controller;


import com.covidmonitor.model.Funcionario;
import com.covidmonitor.model.Role;
import com.covidmonitor.repository.FuncionarioRepo;
import com.covidmonitor.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioRepo funcionarioRepo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/api/funcionarios")
    Iterable<Funcionario> getFuncionarioes(@RequestParam Optional<Long> id) {

        return funcionarioRepo.findAll();

    }

    @GetMapping("/api/funcionarios/{id}")
    Optional<Funcionario> getFuncionario(@PathVariable long id) {
        return funcionarioRepo.findById(id);
    }

    @PostMapping("/api/funcionarios")
    public String createFuncionario(@RequestBody Funcionario funcionario) {
        Optional<Role> optionTipoFuncionario = roleRepo.findById(funcionario.getIdRole());
        if (!optionTipoFuncionario.isPresent()) {
            return (
                    "Falha na"
            );
        }
        Optional<Funcionario> optionFuncionario = funcionarioRepo.findByUsername(funcionario.getUsername());

        if(optionFuncionario.isPresent()){
            Funcionario funcionario_ = optionFuncionario.get();
            return (
                    "{ \"success\": false, \"funcionario_id\": "+ funcionario_.getId() +", \"funcionario_tipo_id\": "+ funcionario_.getIdRole()+ " }"
            );
        }

        Role role = optionTipoFuncionario.get();
        funcionario.setRole(role);
        funcionario.setSenha(funcionario.getUsername() + "");
        funcionarioRepo.save(funcionario);
        return (
                "{ \"success\": true, \"funcionario_id\": "+ funcionario.getId() +", \"funcionario_tipo_id\": "+ funcionario.getIdRole()+ " }"
        );
    }

    @PutMapping("/api/funcionarios/{id}")
    Optional<Funcionario> updateFuncionario(@RequestBody Funcionario funcionarioRequest, @PathVariable long id) {
        Optional<Funcionario> opt = funcionarioRepo.findById(id);
        if (opt.isPresent()) {
            if (funcionarioRequest.getId() == id) {
                funcionarioRepo.save(funcionarioRequest);
                return opt;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Erro ao alterar dados do Funcionario com id " + id);
    }

    @DeleteMapping(value = "/api/funcionarios/{id}")
    void deleteFuncionario(@PathVariable long id) {
        funcionarioRepo.deleteById(id);
    }
	
}
