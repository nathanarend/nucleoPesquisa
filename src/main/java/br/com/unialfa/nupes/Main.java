package br.com.unialfa.nupes;

import br.com.unialfa.nupes.controller.PrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	PrincipalController pc;

	@Override
	public void start(Stage primaryStage) {
		try {
			// AnchorPane root =
			// FXMLLoader.load(getClass().getResource("./view/FXMLLogin.fxml"));
			AnchorPane root = FXMLLoader.load(getClass().getResource("./view/FXMLLogin.fxml"));
			Scene scene = new Scene(root, 774, 521);
			primaryStage.setTitle("Login");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("./image/LOGOUNIALFA.png")));
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Connection Open!");
	}

	public static void main(String[] args) {
		launch(args);
		;
	}
}
