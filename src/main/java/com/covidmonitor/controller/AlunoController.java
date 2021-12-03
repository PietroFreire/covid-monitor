package com.covidmonitor.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import com.covidmonitor.model.Aluno;
import com.covidmonitor.model.Role;
import com.covidmonitor.repository.AlunoRepo;
import com.covidmonitor.repository.RoleRepo;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AlunoController {
    @Autowired
    private AlunoRepo alunoRepo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/api/alunos")
    Iterable<Aluno> getAluno(@RequestParam Optional<Long> id) {

        return alunoRepo.findAll();

    }

    @GetMapping("/api/alunos/{id}")
    Optional<Aluno> getAluno(@PathVariable long id) {
        return alunoRepo.findById(id);
    }

    @PostMapping("/api/alunos")
    public String createAluno(@RequestBody Aluno aluno) {
        Optional<Role> optionTipoAluno = roleRepo.findById(aluno.getIdRole());
        if (!optionTipoAluno.isPresent()) {
            return (
                    "Falha na"
            );
        }
        Optional<Aluno> optionAluno = alunoRepo.findByUsername(aluno.getUsername());

        if(optionAluno.isPresent()){
            Aluno aluno_ = optionAluno.get();
            return (
                    "{ \"success\": false, \"aluno_id\": "+ aluno_.getId() +", \"aluno_tipo_id\": "+ aluno_.getIdRole()+ " }"
            );
        }

        Role role = optionTipoAluno.get();
        aluno.setRole(role);
        aluno.setSenha(aluno.getUsername() + "");
        alunoRepo.save(aluno);
        return (
                "{ \"success\": true, \"aluno_id\": "+ aluno.getId() +", \"aluno_tipo_id\": "+ aluno.getIdRole()+ " }"
        );
    }

    @PutMapping("/api/alunos/{id}")
    Optional<Aluno> updateAluno(@RequestBody Aluno alunoRequest, @PathVariable long id) {
        Optional<Aluno> opt = alunoRepo.findById(id);
        if (opt.isPresent()) {
            if (alunoRequest.getId() == id) {
                alunoRepo.save(alunoRequest);
                return opt;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Erro ao alterar dados do aluno com id " + id);
    }

    @DeleteMapping(value = "/api/alunos/{id}")
    void deleteAluno(@PathVariable long id) {
        alunoRepo.deleteById(id);
    }
}
