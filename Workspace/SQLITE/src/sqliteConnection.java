
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqliteConnection {
	/**
	 * Connect to a sample database
	 * 
	 * @return
	 */
	public static Connection connect() {
		Connection conn = null;
		try {

			String url = "jdbc:sqlite:src/sejarah.sqlite";
			// create a connection to the database
			conn = DriverManager.getConnection(url);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

}
