package testarea;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scene.HowToPlayScene;
import scene.MainMenuScene;

public class TestingGroundsA2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene1 = new HowToPlayScene();
		primaryStage.setScene(scene1);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
