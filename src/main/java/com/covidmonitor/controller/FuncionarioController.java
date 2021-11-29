package com.covidmonitor.controller;

import java.io.IOException;

import com.covidmonitor.model.Funcionario;
import com.covidmonitor.model.Role;
import com.covidmonitor.repository.FuncionarioRepo;
import com.covidmonitor.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;
import com.covidmonitor.LerCSV_Funcionario;

@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioRepo funcionarioRepo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/api/funcionarios")
    public List<Funcionario> getFuncionario(){
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarioRepo.findAll().forEach(funcionarios::add);
        return funcionarios;
    }

    @GetMapping("/api/funcionarios/{id}")
    public Funcionario getFuncionario(@PathVariable long id) {
        Optional<Funcionario> retorno = funcionarioRepo.findById(id);
        Funcionario funcionario = null;
        if(retorno.isPresent()) {
            funcionario = retorno.get();
        }
        return funcionario;
    }

    @PostMapping("/api/funcionarios")
    public String createFuncionario(@RequestBody Funcionario funcionario) {
        Optional<Role> optionTipoUsuario = roleRepo.findById(funcionario.getIdRole());
        if (!optionTipoUsuario.isPresent()) {
            return (
               "{ \"success\": false, \"usuario_id\": 0, \"usuario_tipo_id\": 0 }"
            );
        }
        Optional<Funcionario> optionUsu = funcionarioRepo.findByUsername(funcionario.getUsername());

        if(optionUsu.isPresent()){
            Funcionario u = optionUsu.get();
            return (
               "{ \"success\": false, \"usuario_id\": "+ u.getId() +", \"usuario_tipo_id\": "+ u.getIdRole()+ " }"
            );
        }

        Role l = optionTipoUsuario.get();
        funcionario.setRole(l);
        funcionario.setSenha(funcionario.getUsername() + "");
    	funcionarioRepo.save(funcionario);
        return (
            "{ \"success\": true, \"usuario_id\": "+ funcionario.getId() +", \"usuario_tipo_id\": "+ funcionario.getIdRole()+ " }"
        );
    }

    @PostMapping("/api/funcionarios/csv")
    public ArrayList<Funcionario> createFuncionario(@RequestParam("file") MultipartFile file) {
        try {
            LerCSV_Funcionario csv = new LerCSV_Funcionario();
            ArrayList<Funcionario> funcionarios =  csv.lerUsuario(file.getInputStream());
            for (Funcionario u : funcionarios) {
                Optional<Funcionario> optionUsu = funcionarioRepo.findByUsername(u.getUsername());
                if(optionUsu.isPresent()){
                    continue;
                }
                Optional<Role> optionTipoUsuario = roleRepo.findById(u.getIdRole());
                if (!optionTipoUsuario.isPresent()) {
                    continue;
                }
                Role l = optionTipoUsuario.get();
                u.setRole(l);
                u.setSenha(u.getUsername() + "");
                funcionarioRepo.save(u);
            }
            return funcionarios;
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    @PutMapping("/api/funcionarios/{id}")
    public Funcionario updateFuncionario(@RequestBody Funcionario a, @PathVariable long id) {
        Funcionario funcionario = null;
    	funcionario = this.getFuncionario(id);
        if(funcionario != null) {
            funcionarioRepo.save(a);
            funcionario = a;
        }
        return a;
    }

    @DeleteMapping(value = "/api/funcionarios/{id}", produces = "application/json")
    public String deleteFuncionario(@PathVariable long id) {
        Funcionario funcionario = this.getFuncionario(id);
        boolean result = false;
        if(funcionario != null) {
            funcionarioRepo.delete(funcionario);
            result = true;
        }
        return "{ \"sucess\" : " + (result ? "true" : "false" ) + " }";
    }
	
}
