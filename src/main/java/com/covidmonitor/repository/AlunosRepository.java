package com.covidmonitor.repository;

import com.covidmonitor.usuarios.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<Alunos, Long> {
}