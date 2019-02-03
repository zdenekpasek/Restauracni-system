package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import launcher.ConnectionDB;

public class DeleteFoodController {

	public DeleteFoodController() {

	}

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

	@FXML
	public void goLogin(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("login");

	}

	@FXML
	public void goMenu(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("dashboardAdmin");

	}

	@FXML
	public void goAdd(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("addFood");

	}

	@FXML
	public void goReservation(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("reservationAdmin");
	}

	@FXML
	public void addFood(ActionEvent event) throws ClassNotFoundException, SQLException {

		if (ConnectionDB.insertFood(nameTextField.getText(), priceTextField.getText())) {
			errorMessage.setText("Food successfully added.");

		} else {
			errorMessage.setText("Error, food couldn't be added.");

		}

	}

	public void deleteFood(ActionEvent event) throws ClassNotFoundException {
		try {
			ConnectionDB.deleteFood(nameTextField.getText());
			errorMessage.setText("Food successfully deleted.");
			nameTextField.clear();
		} catch (SQLException e) {
			errorMessage.setText("Error, food couldn't be deleted.");
		}
	}

}
