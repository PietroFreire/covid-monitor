package com.covidmonitor.controller;


import com.covidmonitor.dto.AlunoDto;
import com.covidmonitor.dto.FuncionarioDto;
import com.covidmonitor.model.Aluno;
import com.covidmonitor.model.Funcionario;
import com.covidmonitor.repository.AlunoRepository;
import com.covidmonitor.repository.FuncionarioRepository;
import com.covidmonitor.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/membro")
public class AdminController {

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("escolhaTipo")
    public String escolhaTipo(){
        return "escolhaTipo";
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("formularioAluno")
    public String formularioAluno(AlunoDto requisicao){
        return "formularioAluno";
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("formularioFuncionario")
    public String formularioFuncionario(FuncionarioDto requisicao){
        return "formularioFuncionario";
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("novoAluno")
    public String novoAluno(@Valid AlunoDto requisicao, BindingResult result){
        if(result.hasErrors()){
            return "formularioAluno";
        }
        Aluno aluno = requisicao.toAluno();
//        String pwd = aluno.getSenha();
//        String encryptPdw = passwordEncoder.encode(pwd);
//        aluno.setSenha(encryptPdw);
        membroRepository.save(aluno);
        return "escolhaTipo";
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("novoFuncionario")
    public String novoFuncionario(@Valid FuncionarioDto requisicao, BindingResult result){
        if(result.hasErrors()){
            return "formularioFuncionario";
        }
        Funcionario funcionario = requisicao.toFuncionario();
//        String pwd = funcionario.getSenha();
//        String encryptPdw = passwordEncoder.encode(pwd);
//        funcionario.setSenha(encryptPdw);
        membroRepository.save(funcionario);
        return "escolhaTipo";
    }

}
