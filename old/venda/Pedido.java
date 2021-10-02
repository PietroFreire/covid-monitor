package venda;

import connection.ReadBD;
import estadoSaude.EstadoSaude;
import tadPilha.TADPilha;

import java.sql.SQLException;
import java.util.Scanner;

public class Pedido {

    private int quantidadeTotal;
    private EstadoSaude estadoSaude;
    private double valorTotal;
    private TADPilha fPedido = new TADPilha(15);
    private TADPilha fQuantidade = new TADPilha(15);

    //MÉTODO CONSTRUTOR
    public Pedido(){}

    //MÉTODO SETTER PARA DEFINIR PRODUTOS AO PEDIDO
    public void setPedido(EstadoSaude estadoSaude){
        this.estadoSaude = estadoSaude;
        fPedido.inserir(estadoSaude.getId());
    }

    //MÉTODO SETTER PARA DEFINIR A QUANTIDADE PRODUTOS AO PEDIDO
    public void setQuantidade(int quantidade, double valor){
        this.quantidadeTotal += quantidade;
        fQuantidade.inserir(quantidade);
        this.valorTotal += (quantidade * valor);
    }

    //RETORNA O CARRINHO DE COMPRAS COM TODOS OS PRODUTOS
    public String getPedido() throws SQLException, ClassNotFoundException {
        String p ="=======================\n" +
                "  Carrinho de Compras\n" +
                "=======================\n";
        for(int i = 0; i < fPedido.tamanho(); i++) {
            EstadoSaude estadoSaude =  ReadBD.getProdutoById(fPedido.getElemento(i));
            p +=    "|ID: " + estadoSaude.getId() +"\n"+
                    "|Produto: " + estadoSaude.getNome() +"\n"+
                    "|Quantidade: " + fQuantidade.getElemento(i) +"\n"+
                    "|Valor: " + "R$"+ estadoSaude.getValorVenda() +"\n"+
                    "=======================\n";
        }
        p += "Valor Total: R$" + valorTotal + "\n";
        return p;
    }

    //METODO PARA ALTERAR ALGUM PRODUTO DO CARRINHO DE COMPRAS
    public void alteraPedido() throws SQLException, ClassNotFoundException {
        int menu = 0;
        int indice = 0;
        int id = 0;
        Scanner in = new Scanner(System.in);

        do{
            System.out.println("[!] O que voce gostaria de fazer?\n" +
                    "[1] Excluir o produto\n" +
                    "[2] Alterar o produto\n" +
                    "[3] Sair");
            menu = in.nextInt();
            if(menu !=3) {
                System.out.println("[!] Qual é o id do produto que deseja alterar? ");
                id = in.nextInt();
                indice = fPedido.procurar(id);
            }
            if(indice == 0){
                System.out.println("[!] Produto não está no pedido! \n");
            }else {

                if (menu == 1) {
                    EstadoSaude estadoSaude = ReadBD.getProdutoById(id);
                    double valor = estadoSaude.getValorVenda();
                    int quantidade = fQuantidade.getElemento(indice-1);
                    this.valorTotal -= (quantidade * valor);

                    fPedido.removeElementoN(indice);
                    fQuantidade.removeElementoN(indice);
                    System.out.println(getPedido());
                }
                if(menu == 2){
                    int novoId;
                    int novaQuantidade;

                    double valor = ReadBD.getValorById(id);
                    int quantidade = fQuantidade.getElemento(indice-1);
                    this.valorTotal -= (quantidade * valor);

                    System.out.println("[!] Qual é o id do novo produto? ");
                    novoId = in.nextInt();
                    System.out.println("[!] Qual é a quantidade do novo produto? ");
                    novaQuantidade = in.nextInt();

                    double valor2 = ReadBD.getValorById(novoId);
                    this.valorTotal += (novaQuantidade * valor2);
                    System.out.println(novaQuantidade);
                    System.out.println(valor2);

                    fPedido.alteraElementoN(indice, novoId);
                    fQuantidade.alteraElementoN(indice, novaQuantidade);
                    System.out.println(getPedido());
                }
            }
        }while(menu != 3);

    }

}
