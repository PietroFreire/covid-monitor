package com.covidmonitor.controller;


import com.covidmonitor.dto.AlunoDto;
import com.covidmonitor.dto.FuncionarioDto;
import com.covidmonitor.model.Aluno;
import com.covidmonitor.model.Funcionario;
import com.covidmonitor.repository.AlunoRepository;
import com.covidmonitor.repository.FuncionarioRepository;
import com.covidmonitor.repository.MembroRepository;
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
    private MembroRepository membroRepository;


    @GetMapping("escolhaTipo")
    public String escolhaTipo(){
        return "escolhaTipo";
    }

    @GetMapping("formularioAluno")
    public String formularioAluno(AlunoDto requisicao){
        return "base";
    }

    @GetMapping("formularioFuncionario")
    public String formularioFuncionario(FuncionarioDto requisicao){
        return "home";
    }


    @PostMapping("novoAluno")
    public String novoAluno(@Valid AlunoDto requisicao, BindingResult result){
        if(result.hasErrors()){
            return "formularioAluno";
        }
        Aluno aluno = requisicao.toAluno();
        membroRepository.save(aluno);
        return "escolhaTipo";
    }

    @PostMapping("novoFuncionario")
    public String novoFuncionario(@Valid FuncionarioDto requisicao, BindingResult result){
        if(result.hasErrors()){
            return "formularioFuncionario";
        }
        Funcionario funcionario = requisicao.toFuncionario();
        membroRepository.save(funcionario);
        return "escolhaTipo";
    }

}
