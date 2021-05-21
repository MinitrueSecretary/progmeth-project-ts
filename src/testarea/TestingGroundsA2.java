package testarea;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scene.HowToPlayScene;
import scene.MainMenuScene;
import scene.SceneManager0;
import scene.VictoryScene;

public class TestingGroundsA2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		SceneManager0.setPrimaryStage(primaryStage);
		SceneManager0.instantiateScenes();
		
		Scene scene = SceneManager0.getMainMenu();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
