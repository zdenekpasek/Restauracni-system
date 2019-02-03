package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import launcher.ConnectionDB;

public class RegisterController {
	@FXML
	private TextField usernameTextField;
	@FXML
	private TextField firstNameTextField;
	@FXML
	private TextField lastNameTextField;
	@FXML
	private PasswordField passwordPasswordField;
	@FXML
	private Button registerButton;
	@FXML
	private Button goBackButton;

	public RegisterController() {

	}

	// volani metody insert, ktera vklada do DB udaje o registraci (po registraci
	// switchne na login)
	@FXML
	public void register(ActionEvent event) {
		ConnectionDB.insert(usernameTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText(),
				passwordPasswordField.getText());
		SceneSwitcher.sceneSwitcher.activate("login");
	}

	// prepnuti sceny z registru zpet na login //
	@FXML
	public void goBack(ActionEvent event) {
		SceneSwitcher.sceneSwitcher.activate("login");

	}

}
