import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	// EXAMPLE FOR SELECT COMMAND
	public static void selectAll() {
		String sql = "SELECT * FROM tokoh";

		try {
			Connection conn = sqliteConnection.connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("kode_tokoh") + "\t" + rs.getString("nama_tokoh") + "\t"
						+ rs.getString("kategori_tokoh"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// EXAMPLE FOR INSERT COMMAND
	public static void insert() {
		String sql = "INSERT INTO tokoh(kode_tokoh,nama_tokoh, kategori_tokoh) VALUES('109','Imam','hahaha');";

		try {
			Connection conn = sqliteConnection.connect();
			Statement stmt = conn.createStatement();
			stmt.executeQuery(sql);

		} catch (SQLException e) {
			// System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		insert();
		selectAll();
	}

}
