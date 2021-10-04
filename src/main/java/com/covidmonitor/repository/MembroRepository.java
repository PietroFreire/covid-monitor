package com.covidmonitor.repository;

import com.covidmonitor.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository extends JpaRepository<Membro, Long> {
    Membro findByUsername(String username);
}