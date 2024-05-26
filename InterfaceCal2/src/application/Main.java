package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/gui/View.fxml")); // ta trazendo a tela do view.fxml que ta trazendo do scene com o método getclass e resource obj:tipo parent (superclass do anchorpane)
			Scene scene = new Scene(parent); //cena
			stage.setScene(scene); // palco com a cena
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
