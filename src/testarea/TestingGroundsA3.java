package testarea;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import roots.HowToPlayRoot;
import roots.MainMenuRoot;
import roots.NewSceneManager;
import roots.VictoryRoot;
import scene.HowToPlayScene;
import scene.MainMenuScene;
import scene.SceneManager;
import scene.VictoryScene;

public class TestingGroundsA3 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		NewSceneManager.setPrimaryStage(primaryStage);
		NewSceneManager.instantiateScenes();
		
		Scene scene = NewSceneManager.getMainMenu();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}

