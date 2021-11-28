package br.mackenzie.covidMonitor.funcionarios;

import java.util.Optional;

import br.mackenzie.covidMonitor.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
class ProfessorController {

	@Autowired
	private ProfessorRepo professorRepo;

	@Autowired
	private br.mackenzie.covidMonitor.repository.FuncionarioRepo funcionarioRepo;

	public ProfessorController() {

	}

	@GetMapping("/api/professores")
	Iterable<Funcionario> getfuncionarios(@RequestParam Optional<Long> faculdadeId) {

		return funcionarioRepo.findAll();

	}

	@GetMapping("/api/professores/{id}")
	Optional<Funcionario> getProfessor(@PathVariable long id) {
		return funcionarioRepo.findById(id);
	}

	@PostMapping("/api/professores")
	Funcionario createProfessor(@RequestBody Funcionario p) {
		Funcionario createdProf = funcionarioRepo.save(p);
		return createdProf;
	}

	@PutMapping("/api/professores/{professorId}")
	Optional<Funcionario> updateProfessor(@RequestBody Funcionario funcionarioRequest, @PathVariable long funcionarioId) {
		Optional<Funcionario> opt = funcionarioRepo.findById(funcionarioId);
		if (opt.isPresent()) {
			if (funcionarioRequest.getIdMembro() == funcionarioId) {
				funcionarioRepo.save(funcionarioRequest);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Erro ao alterar dados do funcionarios com id " + funcionarioId);
	}

	@DeleteMapping(value = "/api/professores/{id}")
	void deleteProfessor(@PathVariable long id) {
		funcionarioRepo.deleteById(id);
	}
}
