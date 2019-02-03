package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import launcher.LoginConnection;

public class LoginController {

	@FXML
	private TextField usernameTextField;
	@FXML
	private PasswordField passwordPasswordField;
	@FXML
	private Button loginButton;
	@FXML
	private Button CreateAccountButton;
	@FXML
	private Label errorMessage;

	// metoda pro overeni kdo se loguje do DB //
	@FXML
	public void login(ActionEvent event) throws IOException {
		LoginConnection loginConnection = new LoginConnection();
		// do inputu nahraju jake username uzivatel napsal //
		String input = usernameTextField.getText();
		// pokud zadane username a heslo je v zaznamu DB vypis Success //
		if (loginConnection.login(usernameTextField.getText(), passwordPasswordField.getText())) {
			System.out.println("Succes");
			// pokud se input = admin tak prejdi do dashboardAdmin //
			if (input.equals("admin")) {
				SceneSwitcher.sceneSwitcher.addScreen("dashboardAdmin",
						FXMLLoader.load(getClass().getResource("../DashboardAdmin.fxml")));
				goDashboardAdmin(event);
				// pokud uzivatel neni admin tak prejdi do dashboardCustomer
			} else {
				SceneSwitcher.sceneSwitcher.addScreen("dashboardCustomer",
						FXMLLoader.load(getClass().getResource("../DashboardCustomer.fxml")));
				goDashboardCustomer(event);
			}
			// jestlize zadane udaje nesouhlasi se selectem DB vypis errorMessage //
		} else {
			System.out.println("fail");
			errorMessage.setText("You have entered an invalid username or password.");
		}

	}

	//
	@FXML
	public void goRegister(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("register");

	}

	@FXML
	public void goDashboardAdmin(ActionEvent event) {
		SceneSwitcher.sceneSwitcher.activate("dashboardAdmin");

	}

	@FXML
	public void goDashboardCustomer(ActionEvent event) {
		SceneSwitcher.sceneSwitcher.activate("dashboardCustomer");

	}

}
