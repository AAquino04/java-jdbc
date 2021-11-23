import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		Connection connection = new ConnectionFactory().getConnection();
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
