package br.mackenzie.covidMonitor.repository;

import br.mackenzie.covidMonitor.model.Membro;
import org.springframework.data.repository.CrudRepository;

public interface MembroRepo extends CrudRepository<Membro, Long> {
}