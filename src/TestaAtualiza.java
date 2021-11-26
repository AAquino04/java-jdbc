import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaAtualiza {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		Statement stmt = connection.createStatement();

		stmt.execute("UPDATE produto SET descricao = 'Mouse Sem Fio' WHERE ID = 3");

		connection.close();

	}

}
