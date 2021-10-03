package com.covidmonitor.repository;

import com.covidmonitor.relatorios.Relatorios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatoriosRepository extends JpaRepository<Relatorios, Long> {
}