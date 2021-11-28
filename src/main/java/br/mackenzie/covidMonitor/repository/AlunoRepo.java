package br.mackenzie.covidMonitor.repository;

import br.mackenzie.covidMonitor.model.Aluno;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepo extends CrudRepository<Aluno, Long> {
}