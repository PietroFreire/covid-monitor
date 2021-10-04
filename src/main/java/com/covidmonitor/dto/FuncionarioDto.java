package com.covidmonitor.dto;

import com.covidmonitor.model.Funcionario;
import com.covidmonitor.model.Setor;

public class FuncionarioDto {

    protected String nome;
    protected String senha;
    protected String data_nascimento;
    protected String cidade;
    protected String estado_saude;
    protected String num_funcional;
    protected String setor;

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

    public String getNum_funcional() {
        return num_funcional;
    }

    public void setNum_funcional(String num_funcional) {
        this.num_funcional = num_funcional;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Funcionario toFuncionario()  {
        Funcionario funcionario = new Funcionario(getNome(),getSenha(), getData_nascimento(), getCidade(), getEstado_saude(), getNum_funcional(), getSetor());
        funcionario.setNome(nome);
        funcionario.setSenha(senha);
        funcionario.setData_nascimento(data_nascimento);
        funcionario.setCidade(cidade);
        funcionario.setEstado_saude(estado_saude);
        funcionario.setNum_funcional(num_funcional);
        funcionario.setSetor(setor);
        return funcionario;
    }
}
