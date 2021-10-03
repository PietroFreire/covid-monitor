package com.covidmonitor.repository;

import com.covidmonitor.usuarios.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {
}