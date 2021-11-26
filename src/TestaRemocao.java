import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		Statement stmt = connection.createStatement();

		stmt.execute("DELETE FROM produto WHERE ID > 5");
		Integer linhasModificadas = stmt.getUpdateCount();
		
		System.out.printf("Quantidade de linhas modificadas: %s", linhasModificadas);
		
		connection.close();

	}

}
