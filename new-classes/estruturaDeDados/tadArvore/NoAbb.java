package com.covidmonitor.estruturaDeDados.tadArvore;

public class NoAbb {

    public NoAbb(double valor, String nome) {
        if (nome == null) {
            nome = "--n.def.--";
        }
        this.valor = valor;
        this.nome = nome;
        noAbbDireita = null;
        noAbbEsquerda = null;
    }

    private double valor;
    private String nome;
    private NoAbb noAbbEsquerda;
    private NoAbb noAbbDireita;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor =  valor;
    }

    public String getNome(){ return nome; }

    public void setNome(String nome){ this.nome = nome;}

    public NoAbb getNoAbbEsquerda() {
        return noAbbEsquerda;
    }

    public void setNoAbbEsquerda(NoAbb noAbbEsquerda) {
        this.noAbbEsquerda = noAbbEsquerda;
    }

    public NoAbb getNoAbbDireita() {
        return noAbbDireita;
    }

    public void setNoAbbDireita(NoAbb noAbbDireita) {
        this.noAbbDireita = noAbbDireita;
    }

}
