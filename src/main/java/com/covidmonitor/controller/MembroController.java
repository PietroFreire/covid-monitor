package com.covidmonitor.controller;


import com.covidmonitor.dto.AlunoDto;
import com.covidmonitor.dto.FuncionarioDto;
import com.covidmonitor.model.Aluno;
import com.covidmonitor.model.Funcionario;
import com.covidmonitor.repository.AlunoRepository;
import com.covidmonitor.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/membro")
public class MembroController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/escolhaTipo")
    public String escolhaTipo(){
        return "escolhaTipo";
    }

    @GetMapping("/formularioAluno")
    public String formularioAluno(AlunoDto requisicao){
        return "formularioAluno";
    }

    @GetMapping("/formularioFuncionario")
    public String formularioFuncionario(FuncionarioDto requisicao){
        return "formularioFuncionario";
    }


    @PostMapping("/novoAluno")
    public String novoAluno(@Valid AlunoDto requisicao, BindingResult result){
        if(result.hasErrors()){
            return "formularioAluno";
        }
        Aluno aluno = requisicao.toAluno();
        alunoRepository.save(aluno);
        return "escolhaTipo";
    }

    @PostMapping("/novoFuncionario")
    public String novoFuncionario(@Valid FuncionarioDto requisicao, BindingResult result){
        if(result.hasErrors()){
            return "formularioFuncionario";
        }
        Funcionario funcionario = requisicao.toFuncionario();
        funcionarioRepository.save(funcionario);
        return "escolhaTipo";
    }

}
