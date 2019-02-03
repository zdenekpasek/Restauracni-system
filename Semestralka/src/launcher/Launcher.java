package launcher;

import controllers.SceneSwitcher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

	// hlavni spousteci metoda //
	@Override
	public void start(Stage primaryStage) throws Exception {
		// nacteni primarni sceny Login //
		Parent root = FXMLLoader.load(getClass().getResource("../LoginView.fxml"));

		Scene scene = new Scene(root);

		// pridani scen //
		SceneSwitcher.sceneSwitcher = new SceneSwitcher(scene);
		SceneSwitcher.sceneSwitcher.addScreen("login", FXMLLoader.load(getClass().getResource("../LoginView.fxml")));
		SceneSwitcher.sceneSwitcher.addScreen("register",
				FXMLLoader.load(getClass().getResource("../RegisterView.fxml")));
		SceneSwitcher.sceneSwitcher.addScreen("addFood", FXMLLoader.load(getClass().getResource("../AddFood.fxml")));
		SceneSwitcher.sceneSwitcher.addScreen("deleteFood",
				FXMLLoader.load(getClass().getResource("../DeleteFood.fxml")));
		SceneSwitcher.sceneSwitcher.addScreen("reservation",
				FXMLLoader.load(getClass().getResource("../ReservationView.fxml")));
		SceneSwitcher.sceneSwitcher.addScreen("reservationAdmin",
				FXMLLoader.load(getClass().getResource("../ReservationAdmin.fxml")));
		// spusteni primarni sceny //
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
