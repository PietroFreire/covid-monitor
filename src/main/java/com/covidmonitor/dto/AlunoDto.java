package com.covidmonitor.dto;

import com.covidmonitor.model.Aluno;

import javax.validation.constraints.NotBlank;

public class AlunoDto {

    @NotBlank
    protected String nome;

    @NotBlank
    protected String senha;

    @NotBlank
    protected String data_nascimento;

    @NotBlank
    protected String cidade;

    @NotBlank
    protected String estado_saude;

    @NotBlank
    protected String num_matricula;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado_saude() {
        return estado_saude;
    }

    public void setEstado_saude(String estado_saude) {
        this.estado_saude = estado_saude;
    }

    public String getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(String num_matricula) {
        this.num_matricula = num_matricula;
    }

    public Aluno toAluno()  {
        Aluno aluno = new Aluno(getNome(),getSenha(), getData_nascimento(), getCidade(), getEstado_saude(), getNum_matricula());
        aluno.setNome(nome);
        aluno.setSenha(senha);
        aluno.setData_nascimento(data_nascimento);
        aluno.setCidade(cidade);
        aluno.setEstado_saude(estado_saude);
        aluno.setNum_matricula(num_matricula);
        return aluno;
    }
}
