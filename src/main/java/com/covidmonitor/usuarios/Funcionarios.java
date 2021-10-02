package com.covidmonitor.usuarios;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Funcionarios")
@DiscriminatorValue("Funcionarios")
public class Funcionarios extends Membros {

    @Column(name = "num_funcional")
    private String num_funcional;

    public Funcionarios(Long id, String nome, String senha, String data_nascimento, String cidade, String estado_saude, String num_funcional){
        super(id, nome, senha, data_nascimento, cidade, estado_saude);
        this.num_funcional = num_funcional;
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