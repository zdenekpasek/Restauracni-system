package controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import launcher.ConnectionDB;

public class ReservationController implements Initializable {

	private List<Integer> clickedTables = new ArrayList<>();

	@FXML
	private Button menuButton;
	@FXML
	private Button reservationButton;
	@FXML
	private Button logoutButton;
	@FXML
	private Button confirmButton;

	@FXML
	private Button tableButton1;
	@FXML
	private Button tableButton2;
	@FXML
	private Button tableButton3;
	@FXML
	private Button tableButton4;

	public ReservationController() {

	}

	@FXML
	public void goLogin(ActionEvent event) {
		SceneSwitcher.sceneSwitcher.activate("login");

	}

	@FXML
	public void goDashboardCustomer(ActionEvent event) {
		SceneSwitcher.sceneSwitcher.activate("dashboardCustomer");

	}

	// action event buttonu pro zmenu barvy stolu //
	@FXML
	public void colorChange(ActionEvent event) {
		Button button = (Button) event.getSource();
		if (clickedTables.contains(Integer.parseInt(button.getText()))) {
			clickedTables.remove(Integer.parseInt(button.getText()));
		} else {
			clickedTables.add(Integer.parseInt(button.getText()));
		}
		// button nacte buttonYellow css //
		button.getStylesheets().add(getClass().getResource("/buttonYellow.css").toExternalForm());
		button.applyCss();
	}

	// action event pro potvrzeni rezervace //
	@FXML
	public void confirm(ActionEvent event) {
		try {

			ConnectionDB.reserveTables(clickedTables);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// list buttonu (stolu) //
		List<Button> buttons = new ArrayList<>();
		buttons.add(tableButton1);
		buttons.add(tableButton2);
		buttons.add(tableButton3);
		buttons.add(tableButton4);
		// list intu //
		List<Integer> reserved = new ArrayList<>();
		try {
			// v reserved je select z tabulky stul a sloupce (4) reserved //
			reserved = ConnectionDB.selectReserved();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// projedu vsechny buttony, v mem pripade 4x//
		for (int i = 0; i < buttons.size(); i++) {
			// pokud hodnota reserved == 1, stul je zarezervovany a button se nastavi na
			// cervenou //
			if (reserved.get(i) == 1) {
				buttons.get(i).getStylesheets().add(getClass().getResource("/buttonRed.css").toExternalForm());
				buttons.get(i).applyCss();
				// jinak se button nastavi na zelenou //
			} else {
				buttons.get(i).getStylesheets().add(getClass().getResource("/buttonGreen.css").toExternalForm());
				buttons.get(i).applyCss();
			}
		}
	}
}