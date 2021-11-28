package br.mackenzie.covidMonitor.model;

import javax.persistence.*;

@Entity
@Table(name="setor")
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSetor;
    String nome;

    public Setor(Long idSetor, String nome){
        this.idSetor = idSetor;
        this.nome = nome;
    }

    public Long getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Long idSetor) {
        this.idSetor = idSetor;
    }

    public Setor(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}