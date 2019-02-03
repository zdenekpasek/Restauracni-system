package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import launcher.ConnectionDB;
import objects.Food;

public class DashboardCustomerController implements Initializable {

	@FXML
	private Button menuButton;
	@FXML
	private Button reservationButton;
	@FXML
	private Button logoutButton;

	@FXML
	private VBox menuLayout;

	private Pane defaultList;

	@FXML
	public void goLogin(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("login");
	}

	@FXML
	public void goReservation(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("reservation");
	}

	public DashboardCustomerController() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		defaultList = (Pane) menuLayout.getChildren().get(0);
		fillData();
	}

	private void fillData() {
		List<Food> foodList = ConnectionDB.selectMenu();
		menuLayout.getChildren().clear();
		menuLayout.getChildren().add(defaultList);
		menuLayout.setSpacing(10);
		for (Food food : foodList) {
			VBox item = new VBox();
			item.setAlignment(Pos.CENTER);
			item.setFillWidth(true);
			Label polozka = new Label(food.getPolozka());
			polozka.setStyle("-fx-font-weight: bold");
			item.getChildren().add(polozka);
			item.getChildren().add(new Label(food.getCena() + " Kc"));
			menuLayout.getChildren().add(item);
		}
	}

	@FXML
	public void refresh(ActionEvent event) {
		fillData();
	}
}
