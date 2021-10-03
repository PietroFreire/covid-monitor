package com.covidmonitor.estadoSaude;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "EstadoSaude")
public class EstadoSaude {

    @javax.persistence.Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    public EstadoSaude(){}

    public EstadoSaude(Long id, String nome){
        this.id = id;
        this.nome = nome;

    }

}
