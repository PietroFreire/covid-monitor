package com.covidmonitor.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idMembro")
public class Aluno extends Membro{

    protected String num_matricula;

    public Aluno(String nome, String senha, String data_nascimento, String cidade, String estado_saude, String num_matricula){
        this.num_matricula = num_matricula;
        this.nome = nome;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.cidade = cidade;
        this.estado_saude = estado_saude;
    }

    public Aluno() {

    }

    public String getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(String num_matricula) {
        this.num_matricula = num_matricula;
    }
}
