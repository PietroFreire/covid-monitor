package com.covidmonitor.dto;

import com.covidmonitor.model.Membro;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MembroDto implements Serializable {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String nome;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "data_nascimento")
    private String data_nascimento;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado_saude")
    private String estado_saude;

    public MembroDto(Long id, String nome, String senha, String data_nascimento, String cidade, String estado_saude){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.cidade = cidade;
        this.estado_saude = estado_saude;
    }

    public MembroDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean login(String senha) {
        if (this.senha == senha) {
            System.out.println("[!] Acesso Permitido!");
            return true;
        } else {
            System.out.println("[!] Acesso Negado!");
            return false;
        }
    }

}
