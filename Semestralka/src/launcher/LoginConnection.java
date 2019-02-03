package launcher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginConnection {
	Connection connection;

	public LoginConnection() {
		connection = ConnectionDB.Connector();
		// pokud Connector vrati null (nepodarilo se prihlasit do DB) vypise error a
		// vypne program //
		if (connection == null) {
			System.out.println("Connection not successfull.");
			System.exit(1);
		}
	}

	public boolean isDbConnected() {

		try {
			return connection.isClosed();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	// metoda SELECTU pro cteni z DB //
	public boolean login(String user, String pass) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		// select vseho z tabulky login //
		String query = "SELECT * FROM login WHERE username = ? and password = ?";
		try {
			// do preparedStatmentu dam me pripojeni do DB a select //
			preparedStatement = connection.prepareStatement(query);
			// z DB vezme hodnotu v sloupci username //
			preparedStatement.setString(1, user);
			// z DB vezme hodnotu v sloupci password //
			preparedStatement.setString(2, pass);

			// vse da do resultSetu a spusti Query //
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		} finally {

		}

	}

}
