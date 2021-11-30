import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT id, nome, descricao FROM produto");

		stmt.execute();
		ResultSet rst = stmt.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("id");
			String nome = rst.getString("nome");
			String descricao = rst.getString("descricao");
			System.out.printf("ID: %s | Nome: %s | Descrição: %s \n", id, nome, descricao);
		}
		
		rst.close();
		stmt.close();
		connection.close();
	}

}
