package connection;

import java.sql.*;

public class CreateBD {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

            String url = "jdbc:mysql://localhost:3306/parisluxury?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String pwd = "root";
            System.out.println(url);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, user, pwd);
            System.out.println("Conectado!");
            String readsql = "INSERT INTO pedido (id, valorTotal);";
            PreparedStatement readStm = conexao.prepareStatement(readsql);
            ResultSet resultSet = readStm.executeQuery();
            while (resultSet.next()) {
                System.out.println("Novo cliente cadastrado. \n# nome: " + resultSet.getString("name") + "\n# telefone:" + resultSet.getString("name"));
            }
            conexao.close();
            System.out.println("Encerrado!");
    }
}
