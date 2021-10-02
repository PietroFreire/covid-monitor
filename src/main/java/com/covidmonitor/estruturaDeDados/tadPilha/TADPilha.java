package com.covidmonitor.estruturaDeDados.tadPilha;

public class TADPilha {
    private final int tamanhoMaximo;
    private int topo;
    private int[] pilha;

    //MÉTODO CONSTRUTOR

    public TADPilha(int TAM) {
        this.tamanhoMaximo = TAM;
        this.topo = -1;
        this.pilha = new int[tamanhoMaximo];
    }

    //=======[ MÉTODOS TRADICIONAIS ]=======//

    //INSERIR ELEMENTO NA PILHA
    public boolean inserir(int n) {
        if (estaCheia()) {
            return false;
        } else {
            topo++;
            pilha[topo] = n;
            return true;
        }
    }

    //REMOVER ELEMENTO DA PILHA
    public int remover() {
        if(estaVazia()){
            return 0;
        }else{
            return pilha[topo--];
        }
    }


    //RETORNA TRUE SE A PILHA ESTAR VAZIA
    public boolean estaVazia() {
        return topo == -1;
    }

    //RETORNA TRUE SE A PILHA ESTIVER CHEIA
    public boolean estaCheia() {
        return topo == tamanhoMaximo - 1;
    }

    //RETORNA UMA STRING COM OS ITENS DA PILHA
    public String imprimirPilha() {
        String p = "";
        p += "[ ";
        if (!estaVazia()) {
            for (int i = 0; i <= topo; i++) {
                p += pilha[i] + " ";
            }
        }
        p += "]";
        return p;
    }

    //RETORNA O TAMANHO MÁXIMO DA PILHA
    public int getTamanhoMaximo() {
        return this.tamanhoMaximo;
    }

    //=======[ MÉTODOS EXTRAS ]=======//

    //RETORNA A QUANTIDADE DE ESPAÇOS DISPONÍVEIS NA PILHA
    public int getDisponibilidade() {
        return (this.tamanhoMaximo - this.topo - 1);
    }

    //VERIFICA SE UM ELEMENTO "X" ESTÁ NA PILHA
    public int procurar(int n) {
        if (n <= 0) {
            return 0;
        }
        for (int i = 0; i <= this.topo; i++) {
            if (n == pilha[i]) {
                return i + 1;
            }
        }
        return 0;
    }

    //VERIFICA O TAMANHO DA PILHA
    public int tamanho() {
        return topo +1;
    }

    //ALTERA UM ELEMENTO NA POSIÇAO "N" DA PILHA
    public int alteraElementoN(int n1, int n2) {
        int[] pilhaAuxiliar = new int[this.tamanhoMaximo];
        int topoAuxiliar = -1;
        int[] pilhaAuxiliar2 = new int[this.tamanhoMaximo];
        int topoAuxiliar2 = -1;
        int x = 0;
        int y = 0;

        //DESEMPILHANDO E ALTERANDO O ELEMENTO
        for(int i = topo; i >= 0; i--){
            if(i == n1-1){
                pilhaAuxiliar[x] = n2;
                topoAuxiliar++;
                x++;
            }else {
                pilhaAuxiliar[x] = pilha[i];
                topoAuxiliar++;
                x++;
            }
        }

        //EMPILHANDO NOVAMENTE
        for(int i = topoAuxiliar; i >= 0; i--){
            pilhaAuxiliar2[y] = pilhaAuxiliar[i];
            topoAuxiliar2++;
            y++;
        }
        this.pilha = pilhaAuxiliar2;
        return -1;
    }

    //REMOVE UM ELEMENTO DA POSIÇÃO "N" DA PILHA
    public int removeElementoN(int n) {
        int[] pilhaAuxiliar = new int[this.tamanhoMaximo];
        int topoAuxiliar = -1;
        int[] pilhaAuxiliar2 = new int[this.tamanhoMaximo];
        int topoAuxiliar2 = -1;
        int x = 0;
        int y = 0;

        //DESEMPILHANDO E REMOVENDO O ELEMENTO
        for(int i = topo; i >= 0; i--){
            if(i == n-1){
                remover();
            }else {
                pilhaAuxiliar[x] = pilha[i];
                topoAuxiliar++;
                x++;
            }
        }

        //EMPILHANDO NOVAMENTE
        for(int i = topoAuxiliar; i >= 0; i--){
            pilhaAuxiliar2[y] = pilhaAuxiliar[i];
            topoAuxiliar2++;
            y++;
        }
        this.pilha = pilhaAuxiliar2;
        return -1;
    }

    //RETORNA O ELEMENTO NA POSIÇÃO "X"
    public int getElemento(int n){
        return pilha[n];
    }
}
