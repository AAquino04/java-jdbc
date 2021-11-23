import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListaProdutos {

	public static void main(String[] args) throws SQLException {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?userTimezone=true&serverTimezone=UTC", "root", "fM@031011");
		Statement stmt = connection.createStatement();

		stmt.execute("SELECT * FROM produto");
		ResultSet rst = stmt.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("id");
			String nome = rst.getString("nome");
			String descricao = rst.getString("descricao");
			System.out.printf("ID: %s | Nome: %s | Descrição: %s \n", id, nome, descricao);
		}
		
		connection.close();
	}

}
