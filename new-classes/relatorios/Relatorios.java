package com.covidmonitor.relatorios;

import com.covidmonitor.setores.Setores;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Relatorios")
public class Relatorios {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    Setores setor;

    @Column(name = "dataInicial")
    Date dataInicial;

    @Column(name = "dataFinal")
    Date dataFinal;

    public Relatorios(){}

    public Setores getSetor() {
        return setor;
    }

    public void setSetor(Setores setor) {
        this.setor = setor;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}
