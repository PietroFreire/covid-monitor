package br.mackenzie.covidMonitor.model;

import javax.persistence.*;

@Entity
@Table(name="sintoma")
public class Sintoma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSintoma;

    String nome;

    public Long getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(Long idSintoma) {
        this.idSintoma = idSintoma;
    }

    public Sintoma(String nome){
        this.nome = nome;
    }

    public Sintoma(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}