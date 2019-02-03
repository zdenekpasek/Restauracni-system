package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import launcher.ConnectionDB;
import objects.Table;

public class ReservationAdminController implements Initializable {

	@FXML
	private Button menuButton;
	@FXML
	private Button reservationButton;
	@FXML
	private Button logoutButton;
	@FXML
	private Button confirmButton;
	@FXML
	private TableView<Table> resTable;

	@FXML
	public void goMenu(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("dashboardAdmin");

	}

	@FXML
	public void goLogin(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("login");

	}

	@FXML
	public void goAdd(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("addFood");

	}

	@FXML
	public void goDelete(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("deleteFood");
	}

	@FXML
	public void goReservation(ActionEvent event) throws IOException {
		SceneSwitcher.sceneSwitcher.activate("reservationAdmin");

	}

	// slouzi k zobrazeni cisla stolu a jestli je stul zarezervovany nebo ne (1)
	// nebo (2) do tableView//
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// v listu mam SELECT z tabulky stul (1) a (4) sloupec //
		List<Table> tables = ConnectionDB.showReservation();
		TableColumn<Table, Integer> table1 = (TableColumn<Table, Integer>) resTable.getColumns().get(0);
		table1.setCellValueFactory(new PropertyValueFactory<Table, Integer>("cislo"));
		TableColumn<Table, Integer> table2 = (TableColumn<Table, Integer>) resTable.getColumns().get(1);
		table2.setCellValueFactory(new PropertyValueFactory<Table, Integer>("zarezervovano"));

		ObservableList<Table> tableObs = FXCollections.observableArrayList();
		for (Table table : tables) {
			tableObs.add(table);
		}
		resTable.setItems(tableObs);

	}
}
