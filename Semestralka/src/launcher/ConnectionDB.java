package launcher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import objects.Food;
import objects.Table;

public class ConnectionDB {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://80.211.223.249/zdena";

	// Database credentials
	private static final String USER = "zdena";
	private static final String PASS = "123456";

	public static Connection Connector() {
		try {
			// pokud je prihlaseni do DB uspesne vrat conn //
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;

			// pokud prihlaseni selhalo vrat null //
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}

	}

	public static void insert(String username, String firstName, String lastName, String password) {
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();

			String sql = "INSERT INTO login " + "VALUES ('" + username + "', '" + firstName + "', '" + lastName + "', '"
					+ password + "')";

			stmt.executeUpdate(sql);
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean insertFood(String nazev, String cena) throws ClassNotFoundException, SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO polozka_menu " + "VALUES ('" + nazev + "', '" + cena + "')";
			stmt.executeUpdate(sql);
			conn.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static List<Food> selectMenu() {
		List<Food> food = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();

			String sql = "SELECT * FROM polozka_menu";
			ResultSet resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {
				food.add(new Food(resultSet.getString(1), resultSet.getInt(2)));
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return food;
	}

	public static boolean deleteFood(String nazev) throws ClassNotFoundException, SQLException {

		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM polozka_menu WHERE nazev ='" + nazev + "'";

			stmt.executeUpdate(sql);
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public static List<Integer> selectReserved() throws ClassNotFoundException, SQLException {
		List<Integer> values = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM stul";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				values.add(rs.getInt(4));
			}
			conn.close();
			return values;

		} catch (Exception e) {
			return values;
		}

	}

	public static List<Table> showReservation() {
		List<Table> valuess = new ArrayList<>();

		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM stul";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				valuess.add(new Table(rs.getInt(1), rs.getInt(4)));

			}
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return valuess;

	}

	public static boolean reserveTables(List<Integer> tables) throws ClassNotFoundException, SQLException {

		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			for (Integer table : tables) {
				String sql = "UPDATE stul SET reserved = 1 WHERE cislo_stolu = " + table;
				stmt.executeUpdate(sql);
			}

			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}
}
