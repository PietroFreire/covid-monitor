package com.covidmonitor.estruturaDeDados.tadArvore;

public class Abb {

    public NoAbb raiz;

    public void inserir(double valor, String nome) {
        inserir(raiz, valor, nome);
    }

    public void inserir(NoAbb no, double valor, String nome) {
        if (no == null) {
            //System.out.println("Raiz " + valor);
            raiz = new NoAbb(valor, nome);
        } else {
            if (valor < no.getValor()) {
                if (no.getNoAbbEsquerda() != null) {
                    inserir(no.getNoAbbEsquerda(), valor, nome);
                } else {
                    //System.out.println("Inserindo " + valor + " a esquerda de " + no.getValor());
                    no.setNoAbbEsquerda(new NoAbb(valor, nome));
                }

            } else {
                if (no.getNoAbbDireita() != null) {
                    inserir(no.getNoAbbDireita(), valor, nome);
                } else {
                    //System.out.println("Inserindo " + valor + " a direita de " + no.getValor());
                    no.setNoAbbDireita(new NoAbb(valor, nome));
                }
            }
        }
    }

    public String localizar(double v) {
        if (raiz == null) {
            System.out.println("A Árvore de Produtos Esta Vazia!");
        }

        NoAbb cursor = raiz;

        while (true) {

            //= CURSOR = NULO -> NAO LOCALIZOU O ELEMENTO (NAO ESTA' NA ARVORE)
            if (cursor == null) {
                NoAbb _no = new NoAbb(-1, "");
                String p = "Produto Não Localizado Na Árvore!";
                return p;
            }

            //= ENCONTROU -> RETORNA O NO'
            if (cursor.getValor() == v) {
                String p = "[!]Produto Localizado!\n";
                p += "Nome: " + cursor.getNome() + "\n" +
                        "Valor: R$"+ cursor.getValor();
                return p;
            }

            //= CONTINUAR PROCURANDO
            if (v < cursor.getValor()) { // valor menor que o do no' cursor -> ir para a esquerda
                cursor = cursor.getNoAbbEsquerda();
            } else { // valor maior -> ir para a direita
                cursor = cursor.getNoAbbDireita();
            }

        }

    }

    public void ordem(NoAbb no) {
        if (no != null) {
            ordem(no.getNoAbbEsquerda());
            System.out.println( "R$" + no.getValor());
            ordem(no.getNoAbbDireita());

        }
    }

    private void imprimirArvore(NoAbb no) {
        if(no != null) {
            imprimirArvore(no.getNoAbbEsquerda());
            if (no.getNoAbbEsquerda() != null) {
                System.out.println("R$" + no.getValor() + " esta em cima do " +  "R$" + no.getNoAbbEsquerda().getValor() + " que esta a esquerda");
            }
            if (no.getNoAbbDireita() != null) {
                System.out.println("R$" + no.getValor() + " esta em cima do " + "R$" + no.getNoAbbDireita().getValor() + " que esta a direita");
            }

            imprimirArvore(no.getNoAbbDireita());
        }
    }

    public void imprimirArvore() {
        imprimirArvore(this.raiz);
    }

}