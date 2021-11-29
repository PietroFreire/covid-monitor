package com.covidmonitor.repository;

import com.covidmonitor.model.Aluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AlunoRepo extends CrudRepository<Aluno, Long>{

    @Query("select u from Aluno u where u.username = ?1 AND u.senha = ?2")
    Optional<Aluno> logar(int username, String senha);

    @Query("select u from Aluno u where u.username = ?1")
    Optional<Aluno> findByUsername(int username);

}
