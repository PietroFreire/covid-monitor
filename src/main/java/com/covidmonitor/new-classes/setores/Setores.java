package com.covidmonitor.setores;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Setores")
public class Setores {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome")
    String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Setores(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
