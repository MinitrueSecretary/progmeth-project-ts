package application;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.SceneManager;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage)  {
		SceneManager.setPrimaryStage(primaryStage);
		SceneManager.instantiateScenes();
		
		Scene scene = SceneManager.getMainMenu();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tellstones : Intiania's Game Time");
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
