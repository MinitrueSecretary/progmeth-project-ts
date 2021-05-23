package application;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.SceneManager;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage)  {
		SceneManager.setPrimaryStage(primaryStage);
		SceneManager.instantiateScenes();
		
		Scene scene = SceneManager.getMainMenu();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tellstones : Intania's Game Time");
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
