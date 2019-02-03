package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import launcher.ConnectionDB;

public class AddFoodController {
	@FXML
	private Button menuButton;
	@FXML
	private Button addButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button reservationButton;
	@FXML
	private Button logoutButton;
	@FXML
	private Button confirmButton;

	@FXML
	private TextField nameTextField;
	@FXML
	private TextField priceTextField;
	@FXML
	private Label errorMessage;

	public AddFoodController() {

	}

	@FXML
	public void goLogin(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("login");

	}

	@FXML
	public void goMenu(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("dashboardAdmin");

	}

	@FXML
	public void goDelete(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("deleteFood");
	}

	@FXML
	public void goReservation(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("reservationAdmin");
	}

	@FXML
	public void addFood(ActionEvent event) throws ClassNotFoundException, SQLException {

		// pokud admin vyplni jmeno a cenu jidla tak se prida //
		if (ConnectionDB.insertFood(nameTextField.getText(), priceTextField.getText())) {
			errorMessage.setText("Food successfully added.");
			nameTextField.clear();
			priceTextField.clear();

			// pokud ne, vypise chybovou hlasku //
		} else {
			errorMessage.setText("Error, food couldn't be added.");

		}

	}

}
