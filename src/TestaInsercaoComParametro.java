import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO produto (nome, descricao) VALUES (?, ?)",
				Statement.RETURN_GENERATED_KEYS);

		String nome = "Teclado";
		String descricao = "Teclado Mecânico Preto";

		stmt.setString(1, nome);
		stmt.setString(2, descricao);

		stmt.execute();

		ResultSet rs = stmt.getGeneratedKeys();

		while (rs.next()) {
			Integer id = rs.getInt(1);
			System.out.printf("O ID do produto cadastrado foi %s", id);
		}

		connection.close();

	}

}
