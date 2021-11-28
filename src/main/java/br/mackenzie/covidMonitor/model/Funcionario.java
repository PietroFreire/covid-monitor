package br.mackenzie.covidMonitor.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idMembro")
public class Funcionario extends Membro {

    private String num_funcional;

    //    @ManyToOne(fetch = FetchType.LAZY)
    private String setor;

    public Funcionario(String nome, String senha, String data_nascimento, String cidade, String estado_saude, String num_funcional, String setor){
        this.num_funcional = num_funcional;
        this.nome = nome;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.cidade = cidade;
        this.estado_saude = estado_saude;
        this.setor = setor;
    }

    public Funcionario() {
        super();
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
}
