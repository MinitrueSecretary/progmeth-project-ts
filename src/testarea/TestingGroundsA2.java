package testarea;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scene.HowToPlayScene;
import scene.MainMenuScene;
import scene.SceneManager;
import scene.VictoryScene;

public class TestingGroundsA2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		SceneManager.setPrimaryStage(primaryStage);
		SceneManager.instantiateScenes();
		
		Scene scene = SceneManager.getMainMenu();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
