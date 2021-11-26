import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaAtualiza {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement stmt = connection.prepareStatement("UPDATE produto SET descricao = 'Mouse Sem Fio' WHERE ID = 3");

		stmt.execute();

		connection.close();

	}

}
