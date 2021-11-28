package br.mackenzie.covidMonitor.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Membro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idMembro;
    protected String nome;
    protected String username;
    protected String senha;
    protected String data_nascimento;
    protected String cidade;
    protected String estado_saude;
    @ManyToMany(fetch = FetchType.EAGER)
    protected Collection<Role> roles = new ArrayList<>();

//    @OneToOne(fetch = FetchType.LAZY)
//    protected List<Sintoma> sintoma;

    public Membro(Long idMembro, String nome, String username, String senha, String data_nascimento, String cidade, String estado_saude){
        this.idMembro = idMembro;
        this.nome = nome;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.cidade = cidade;
        this.estado_saude = estado_saude;
    }

    public Membro() {

    }

    public Long getIdMembro() {
        return idMembro;
    }

    public void setIdMembro(Long id) {
        this.idMembro = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    //    public boolean login(String senha) {
//        if (this.senha == senha) {
//            System.out.println("[!] Acesso Permitido!");
//            return true;
//        } else {
//            System.out.println("[!] Acesso Negado!");
//            return false;
//        }
//    }
}
