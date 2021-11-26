import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM produto WHERE ID = ?");

		Integer id = 7;
		stmt.setInt(1, id);

		stmt.execute();

		Integer linhasModificadas = stmt.getUpdateCount();
		System.out.printf("Quantidade de linhas modificadas: %s", linhasModificadas);

		connection.close();

	}

}
