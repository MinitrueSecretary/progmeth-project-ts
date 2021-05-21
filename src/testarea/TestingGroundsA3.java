package testarea;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.SceneManager;
import roots.HowToPlayRoot;
import roots.MainMenuRoot;
import roots.VictoryRoot;
import scene.HowToPlayScene;
import scene.MainMenuScene;
import scene.SceneManager0;
import scene.VictoryScene;

public class TestingGroundsA3 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
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

