package com.covidmonitor.repository;

import com.covidmonitor.estadoSaude.Sintomas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SintomasRepository extends JpaRepository<Sintomas, Long> {
}