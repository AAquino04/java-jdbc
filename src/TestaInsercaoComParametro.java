import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().getConnection()) {

			connection.setAutoCommit(false);

			try (PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO produto (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);) {
				adicionarVariavel("Monitor", "Monitor 24 polegadas", stmt);
				adicionarVariavel("Rádio Analógico", "Rádio analógico de bateria", stmt);

				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stmt) throws SQLException {
		stmt.setString(1, nome);
		stmt.setString(2, descricao);

		stmt.execute();

		try (ResultSet rs = stmt.getGeneratedKeys()) {
			while (rs.next()) {
				Integer id = rs.getInt(1);
				System.out.printf("O ID do produto cadastrado foi %s \n", id);
			}
		}
	}
}
