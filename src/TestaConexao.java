import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?userTimezone=true&serverTimezone=UTC", "root", "fM@031011");

		System.out.println("Fechando conexão");
		
		connection.close();
		
	}

}
