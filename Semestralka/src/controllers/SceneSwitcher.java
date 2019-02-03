package controllers;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class SceneSwitcher {

	// Vytvoreni hash mapy pro praci se scenami //
	public static SceneSwitcher sceneSwitcher;
	private HashMap<String, Pane> screenMap = new HashMap<>();
	private Scene main;

	public SceneSwitcher(Scene main) {
		this.main = main;
	}

	// pridani sceny //
	public void addScreen(String name, Pane pane) {
		screenMap.put(name, pane);
	}

	// odebrani sceny //
	protected void removeScreen(String name) {
		screenMap.remove(name);
	}

	// aktivace sceny //
	protected void activate(String name) {
		main.setRoot(screenMap.get(name));
	}
}
