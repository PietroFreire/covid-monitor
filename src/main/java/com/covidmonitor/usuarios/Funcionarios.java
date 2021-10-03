package com.covidmonitor.usuarios;

import com.covidmonitor.setores.Setores;

import javax.persistence.*;

@Entity(name = "Funcionarios")
@DiscriminatorValue("Funcionarios")
public class Funcionarios extends Membros {

    @Column(name = "num_funcional")
    private String num_funcional;

    @Column(name = "isAdm")
    private boolean isAdm;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setores setor;

    public Funcionarios(Long id, String nome, String senha, String data_nascimento, String cidade, String estado_saude, String num_funcional, boolean isAdm, Setores setor){
        super(id, nome, senha, data_nascimento, cidade, estado_saude);
        this.num_funcional = num_funcional;
        this.isAdm = isAdm;
        this.setor = setor;
    }

    public Funcionarios() {
        super();
    }

    public String getnum_funcional() {
        return num_funcional;
    }

    public void setnum_funcional(String num_funcional) {
        this.num_funcional = num_funcional;
    }
}