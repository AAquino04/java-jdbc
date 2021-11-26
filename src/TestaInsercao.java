import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		Connection connection = new ConnectionFactory().getConnection();
		Statement stmt = connection.createStatement();

		stmt.execute("INSERT INTO produto (nome,descricao) VALUES ('Mouse', 'Mouse sem fio')",
				Statement.RETURN_GENERATED_KEYS);

		ResultSet rs = stmt.getGeneratedKeys();

		while (rs.next()) {
			Integer id = rs.getInt(1);
			System.out.printf("O ID do produto cadastrado foi %s", id);
		}

		connection.close();

	}

}
