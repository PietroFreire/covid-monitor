package com.covidmonitor.usuarios;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Alunos")
@DiscriminatorValue("Alunos")
public class Alunos extends Membros {

    @Column(name = "num_matricula")
    private String num_matricula;

    public Alunos(Long id, String nome, String senha, String data_nascimento, String cidade, String estado_saude, String num_matricula){
        super(id, nome, senha, data_nascimento, cidade, estado_saude);
        this.num_matricula = num_matricula;
    }

    public Alunos() {
        super();
    }

    public String getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(String num_matricula) {
        this.num_matricula = num_matricula;
    }
}