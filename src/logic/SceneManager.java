package logic;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import roots.HowToPlayRoot;
import roots.MainGameRoot;
import roots.MainMenuRoot;
import roots.VictoryRoot;

public class SceneManager {
	private static Parent mainMenuR;
	private static Parent howToPlayR;
	private static Parent mainGameR;
	private static Parent victorySceneR;	
	
	private static Stage primaryStage;
	
	private static Scene mainMenu;
	private static Scene howToPlay;	
	private static Scene mainGame;
	private static Scene victoryScene;
	
	
	public static void instantiateScenes() {
		mainMenuR = new MainMenuRoot();
		howToPlayR = new HowToPlayRoot();
		victorySceneR = new VictoryRoot();
		mainMenu = new Scene(mainMenuR, 1100, 750);
		howToPlay = new Scene(howToPlayR, 1100, 750);
		victoryScene = new Scene(victorySceneR, 1100, 750);
	}

	public static void instatiateMainGame() {
		mainGameR = new MainGameRoot();
		mainGame = new Scene(mainGameR, 1100, 750);
	}
	public static void startGameEnd() {
		((VictoryRoot) victorySceneR).declareWinner();
		setScene(victoryScene);
		
	}
	
	public static void setPrimaryStage(Stage primaryStage) {
		SceneManager.primaryStage = primaryStage;
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

	public static Parent getMainMenuR() {
		return mainMenuR;
	}

	public static Parent getHowToPlayR() {
		return howToPlayR;
	}

	public static Parent getMainGameR() {
		return mainGameR;
	}

	public static Parent getVictorySceneR() {
		return victorySceneR;
	}
	

}
