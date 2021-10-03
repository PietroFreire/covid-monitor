package com.covidmonitor.repository;

import com.covidmonitor.estadoSaude.EstadoSaude;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoSaudeRepository extends JpaRepository<EstadoSaude, Long> {
}