package connection;

import com.covidmonitor.repository.estadoSaude.EstadoSaude;
import venda.Pedido;

import java.sql.*;

public class ReadBD {

    //RETORNA O CATÁLOGO DE PRODUTOS DO BANCO DE DADOS
    public static void getCatalogo() throws ClassNotFoundException, SQLException {
        String nome = "";
        int quantidade = 0;
        double valor = 0;
        String url = "jdbc:mysql://localhost:3306/parisluxury?useTimezone=true&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pwd = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(url, user, pwd);
        String readsql = "SELECT * FROM produto";
        PreparedStatement readStm = conexao.prepareStatement(readsql);
        ResultSet resultSet = readStm.executeQuery();
        System.out.println("|====================");
        while (resultSet.next()) {
            System.out.println("|ID: " + (resultSet.getString("id")) );
            System.out.println("|Produto: " + (resultSet.getString("nome")) );
            System.out.println("|Descrição: " + (resultSet.getString("descricao")) );
            System.out.println("|Quantidade em estoque: " + (resultSet.getString("quantidade")) );
            System.out.println("|Valor: " + "R$"+(resultSet.getString("valorVenda")));
            System.out.println("|--------------------");
        }
        System.out.println("|====================");
        System.out.println("\n");
        conexao.close();
    }

    public static void getClientes() throws ClassNotFoundException, SQLException {
        String nome = "";
        int quantidade = 0;
        double valor = 0;
        String url = "jdbc:mysql://localhost:3306/parisluxury?useTimezone=true&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pwd = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(url, user, pwd);
        String readsql = "SELECT * FROM clientes";
        PreparedStatement readStm = conexao.prepareStatement(readsql);
        ResultSet resultSet = readStm.executeQuery();
        System.out.println("|====================");
        while (resultSet.next()) {
            System.out.println("|ID: " + (resultSet.getString("id")) );
            System.out.println("|Nome: " + (resultSet.getString("nome")) );
            System.out.println("|Celular: " + (resultSet.getString("celular")) );
            System.out.println("|Data de Cadastro: " + (resultSet.getString("dataCadastro")) );
            System.out.println("|Email: " +(resultSet.getString("email")));
            System.out.println("|--------------------");
        }
        System.out.println("|====================");
        System.out.println("\n");
        conexao.close();
    }

    //RETORNA UM PRODUTO DO BANCO DE DADOS ATRAVÉS DE SEU ID
    public static EstadoSaude getProdutoById(int id) throws ClassNotFoundException, SQLException {
        String nome = "";
        int quantidade = 0;
        double valor = 0;
        String url = "jdbc:mysql://localhost:3306/parisluxury?useTimezone=true&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pwd = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(url, user, pwd);
        String readsql = "SELECT id, nome, quantidade, valorVenda FROM produto WHERE id = " + id;
        PreparedStatement readStm = conexao.prepareStatement(readsql);
        ResultSet resultSet = readStm.executeQuery();
        while (resultSet.next()) {
            nome = (resultSet.getString("nome"));
            quantidade = (resultSet.getInt("quantidade"));
            valor = (resultSet.getDouble("valorVenda"));

        }
        EstadoSaude estadoSaude = new EstadoSaude(id, nome, quantidade, valor);
        conexao.close();
        return estadoSaude;
    }

    //RETORNA O VALOR DE UM PRODUTO DO BANCO DE DADOS ATRAVÉS DE SEU ID
    public static double getValorById(int id) throws ClassNotFoundException, SQLException {
        double valor = 0;
        String url = "jdbc:mysql://localhost:3306/parisluxury?useTimezone=true&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pwd = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(url, user, pwd);
        String readsql = "SELECT valorVenda FROM produto WHERE id = " + id;
        PreparedStatement readStm = conexao.prepareStatement(readsql);
        ResultSet resultSet = readStm.executeQuery();
        while (resultSet.next()) {
            valor = (resultSet.getDouble("valorVenda"));

        }
        conexao.close();
        return valor;
    }
    //RETORNA O NOME DE UM PRODUTO PELO SEU ID
    public static String getNomeById(int id) throws ClassNotFoundException, SQLException {
        String nome = "";
        String url = "jdbc:mysql://localhost:3306/parisluxury?useTimezone=true&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pwd = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(url, user, pwd);
        String readsql = "SELECT nome FROM produto WHERE id = " + id;
        PreparedStatement readStm = conexao.prepareStatement(readsql);
        ResultSet resultSet = readStm.executeQuery();
        while (resultSet.next()) {
            nome = (resultSet.getString("nome"));

        }
        conexao.close();
        return nome;
    }

    //RETORNA O CARRINHO DO BANCO DE DADOS
    public static Pedido getPedidos() throws ClassNotFoundException, SQLException {
        int id;
        int id2;
        double valorTotal;
        String url = "jdbc:mysql://localhost:3306/parisluxury?useTimezone=true&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pwd = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(url, user, pwd);
        String readsql = "SELECT * FROM Pedido";
        PreparedStatement readStm = conexao.prepareStatement(readsql);
        ResultSet resultSet = readStm.executeQuery();
        while (resultSet.next()) {
            id = (resultSet.getInt("id"));
            valorTotal = (resultSet.getDouble("valorTotal"));
        }
        Pedido pedido = new Pedido();
        conexao.close();
        return pedido;
    }
}