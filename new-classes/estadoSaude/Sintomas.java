package com.covidmonitor.estadoSaude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Sintomas")
public class Sintomas {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Nome")
    String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sintomas(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
