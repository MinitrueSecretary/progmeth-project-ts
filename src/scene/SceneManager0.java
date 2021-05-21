package scene;

import javafx.scene.Scene;
import javafx.stage.Stage;
import scene.HowToPlayScene;
import scene.MainMenuScene;
import scene.VictoryScene;

public class SceneManager0 {
	private static Stage primaryStage;
	private static Scene mainMenu;
	private static Scene howToPlay;
	
	private static Scene mainGame;
	private static Scene victoryScene;
	
	
	public static void instantiateScenes() {
		mainMenu = new MainMenuScene();
		howToPlay = new HowToPlayScene();
		//TODO instantiate this with a main game scene
		victoryScene = new VictoryScene(); 
	}

	public static void setPrimaryStage(Stage primaryStage) {
		SceneManager0.primaryStage = primaryStage;
	}
	
	public static void setScene(Scene scene) {
		primaryStage.setScene(scene);
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	


	public static Scene getMainMenu() {
		return mainMenu;
	}

	public static Scene getHowToPlay() {
		return howToPlay;
	}

	public static Scene getMainGame() {
		return mainGame;
	}

	public static Scene getVictoryScene() {
		return victoryScene;
	}
	
	
}
