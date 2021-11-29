package com.covidmonitor.controller;

import com.covidmonitor.model.Membro;
import com.covidmonitor.repository.MembroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Autenticacao {

    @Autowired
    protected MembroRepo membroRepo;

    @PostMapping("/api/usuarios/logar")
    public Membro logar(@RequestBody Membro membro) {
        Optional<Membro> optionUsu = membroRepo.logar(membro.getUsername(), membro.getSenha());
        Membro usuEncontrado = null;
        if(optionUsu.isPresent()) {
            usuEncontrado = optionUsu.get();
        }
        return usuEncontrado;
    }
}
