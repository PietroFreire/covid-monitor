package com.covidmonitor.controller;

import java.util.List;

import com.covidmonitor.model.Aluno;
import com.covidmonitor.model.Funcionario;
import com.covidmonitor.model.Membro;
import com.covidmonitor.repository.MembroRepository;
import com.covidmonitor.repository.AlunoRepository;
import com.covidmonitor.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping("/")
	public String home(Model model){
//		List<Membro> membros = membroRepository.findAll();
//		model.addAttribute("Membros", membros);
		return "base";
	}

	@GetMapping("/alunos")
	public String alunos(Model model){
		List<Aluno> alunos = alunoRepository.findAll();
		model.addAttribute("Alunos", alunos);
		return "alunos";
	}

	@GetMapping("/funcionarios")
	public String funcionarios(Model model){
		List<Funcionario> funcionario = funcionarioRepository.findAll();
		model.addAttribute("Funcionarios", funcionario);
		return "funcionarios";
	}

}
