package com.covidmonitor.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;
import com.covidmonitor.model.Aluno;
import com.covidmonitor.model.Role;
import com.covidmonitor.repository.AlunoRepo;
import com.covidmonitor.repository.RoleRepo;

@RestController
public class AlunoController {
    @Autowired
    private AlunoRepo alunoRepo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/api/alunos")
    public List<Aluno> getalunos(){
        List<Aluno> alunos = new ArrayList<>();
        alunoRepo.findAll().forEach(alunos::add);
        return alunos;
    }

    @GetMapping("/api/alunos/{id}")
    public Aluno getUsuario(@PathVariable long id) {
        Optional<Aluno> retorno = alunoRepo.findById(id);
        Aluno aluno = null;
        if(retorno.isPresent()) {
            aluno = retorno.get();
        }
        return aluno;
    }

    @PostMapping("/api/alunos")
    public String createUsuario(@RequestBody Aluno aluno) {
        Optional<Role> optionTipoUsuario = roleRepo.findById(aluno.getIdRole());
        if (!optionTipoUsuario.isPresent()) {
            return (
                    "{ \"success\": false, \"usuario_id\": 0, \"usuario_tipo_id\": 0 }"
            );
        }
        Optional<Aluno> optionUsu = alunoRepo.findByUsername(aluno.getUsername());

        if(optionUsu.isPresent()){
            Aluno u = optionUsu.get();
            return (
                    "{ \"success\": false, \"usuario_id\": "+ u.getId() +", \"usuario_tipo_id\": "+ u.getIdRole()+ " }"
            );
        }

        Role l = optionTipoUsuario.get();
        aluno.setRole(l);
        aluno.setSenha(aluno.getUsername() + "");
        alunoRepo.save(aluno);
        return (
                "{ \"success\": true, \"usuario_id\": "+ aluno.getId() +", \"usuario_tipo_id\": "+ aluno.getIdRole()+ " }"
        );
    }

    @PutMapping("/api/alunos/{id}")
    public Aluno updateUsuario(@RequestBody Aluno a, @PathVariable long id) {
        Aluno aluno = null;
        aluno = this.getUsuario(id);
        if(aluno != null) {
            alunoRepo.save(a);
            aluno = a;
        }
        return a;
    }

    @DeleteMapping(value = "/api/alunos/{id}", produces = "application/json")
    public String deleteUsuario(@PathVariable long id) {
        Aluno aluno = this.getUsuario(id);
        boolean result = false;
        if(aluno != null) {
            alunoRepo.delete(aluno);
            result = true;
        }
        return "{ \"sucess\" : " + (result ? "true" : "false" ) + " }";
    }

}
