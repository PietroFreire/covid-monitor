package connection;

import java.sql.*;

public class DeleteBD {
    public static void deleteById(String nome) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/parisluxury?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String pwd = "root";
        System.out.println(url);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(url, user, pwd);
        System.out.println("Conectado!");
        String readsql = "DELETE FROM produto WHERE (nome =" + nome +")";
        PreparedStatement readStm = conexao.prepareStatement(readsql);
        ResultSet resultSet = readStm.executeQuery();
        while (resultSet.next()) {
            System.out.println("Produto Deletado com Sucesso");
        }
        conexao.close();
    }
}
