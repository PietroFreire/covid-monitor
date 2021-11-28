package br.mackenzie.covidMonitor.repository;

import br.mackenzie.covidMonitor.model.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepo extends CrudRepository<Funcionario, Long> {
}