package main;

import connection.ReadBD;
import estadoSaude.EstadoSaude;
import tadArvore.Abb;
import venda.Pedido;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Amanda Ramalho - 41904567 | Gabriel Freire - 41921836 | Gustavo Boteon - 41913469
 */
public class App {
//        Scanner in = new Scanner(System.in);
//        Pedido pedido = new Pedido();
//        EstadoSaude produtos = new EstadoSaude();
//
//        int menu = 0;
//        int menuInicial = 0;
//        int menuAdm = 0;
//        double valor;
//        String nome;
//
//        while(menuInicial != 9){
//            System.out.println("" +
//                    "|===============================|\n" +
//                    "|          ParisLuxury          |\n" +
//                    "|===============================|\n" +
//                    "|1) Administrador               |\n" +
//                    "|2) Cliente                     |\n" +
//                    "|9) Sair                        |\n" +
//                    "|===============================|");
//            System.out.println("Digite a opção desejada: ");
//            menuInicial = in.nextInt();
//
//            if(menuInicial == 1){
//                while(menuAdm != 9 ){
//                    System.out.println("" +
//                            "|===============================|\n" +
//                            "|          ParisLuxury          |\n" +
//                            "|===============================|\n" +
//                            "|1) Ver Valores dos Produtos    |\n" +
//                            "|   em Estoque na estrutura     |\n" +
//                            "|   da Abb                      |\n" +
//                            "|2) Ver Clientes Cadastrados    |\n" +
//                            "|3) Verificar Valores em Ordem  |\n" +
//                            "|   Crescente na Abb            |\n" +
//                            "|4) Encontrar um Produto Pelo   |\n" +
//                            "|   Valor na Abb                |\n" +
//                            "|9) Sair                        |\n" +
//                            "|===============================|");
//                    System.out.println("Digite a opção desejada: ");
//                    menuAdm = in.nextInt();
//
//                    if (menuAdm == 1){
//                        Abb abb = new Abb();
//                        for(int i = 1; i < 6; i++) {
//                            abb.inserir(ReadBD.getValorById(i), ReadBD.getNomeById(i));
//                        }
//                        abb.imprimirArvore();
//                    }else if (menuAdm == 2){
//                        ReadBD.getClientes();
//                    }else if (menuAdm == 3){
//                        Abb abb = new Abb();
//                        for(int i = 1; i <= 6; i++) {
//                            abb.inserir(ReadBD.getValorById(i), ReadBD.getNomeById(i));
//                        }
//                        abb.ordem(abb.raiz);
//                    }else if(menuAdm == 4){
//                        Abb abb = new Abb();
//                        for(int i = 1; i <= 6; i++) {
//                            abb.inserir(ReadBD.getValorById(i), ReadBD.getNomeById(i));
//                        }
//                        System.out.println("Digite o valor do produto que deseja encontrar no estoque: ");
//                        valor = in.nextDouble();
//                        System.out.println(abb.localizar(valor));
//                    }
//                }
//            }
//
//            if(menuInicial == 2){
//                while(menu != 9) {
//                    System.out.println("" +
//                            "|===============================|\n" +
//                            "|          ParisLuxury          |\n" +
//                            "|===============================|\n" +
//                            "|1) Verificar o catálogo        |\n" +
//                            "|2) Criar um pedido             |\n" +
//                            "|3) Alterar um produto do pedido|\n" +
//                            "|4) Verificar o pedido          |\n" +
//                            "|9) Sair                        |\n" +
//                            "|===============================|");
//                    System.out.println("Digite a opção desejada: ");
//                    menu = in.nextInt();
//                    if(menu == 1) {
//                        ReadBD.getCatalogo();
//                    }else if(menu == 2) {
//                        System.out.println("[!] Qual é o id do produto que deseja colocar no pedido? ");
//                        int id = in.nextInt();
//                        System.out.println("[!] E qual é a quantidade? ");
//                        int quantidade = in.nextInt();
//                        produtos = ReadBD.getProdutoById(id);
//                        pedido.setPedido(produtos);
//                        valor = ReadBD.getValorById(id);
//                        pedido.setQuantidade(quantidade, valor);
//                        int menu2 = 0;
//                        do {
//                            System.out.println("" +
//                                    "===========================\n" +
//                                    "1) Adicionar outro produto\n" +
//                                    "2) Sair do pedido\n" +
//                                    "============================");
//                            menu2 = in.nextInt();
//                            if (menu2 == 1){
//                                System.out.println("[!] Qual é o id do produto que deseja colocar no pedido? ");
//                                id = in.nextInt();
//                                produtos = ReadBD.getProdutoById(id);
//                                System.out.println("[!] E qual é a quantidade? ");
//                                quantidade = in.nextInt();
//                                pedido.setPedido(produtos);
//                                valor = ReadBD.getValorById(id) ;
//                                pedido.setQuantidade(quantidade, valor);
//                            }
//                        } while (menu2 != 2);
//                    }else if (menu == 3){
//                        pedido.alteraPedido();
//                    }else if (menu == 4) {
//                        System.out.println(pedido.getPedido());
//                    }
//                }
//            }
//        }

}
