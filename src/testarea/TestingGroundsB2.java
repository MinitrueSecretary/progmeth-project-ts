package testarea;

import gameelement.ButtonPanel;
import gameelement.CentralPane;
import gameelement.PlayZone;
import gameelement.UtilityPane;
import gameelement.UtilityPaneBoast;
import gameelement.UtilityPaneChallenge;
import gameelement.UtilityPanePlace;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.GameController;
import logic.GameStage;
import logic.SceneManager;
import logic.TurnManager;
import roots.MainGameRoot;

public class TestingGroundsB2 extends Application {


	@Override
	public void start(Stage primaryStage) throws Exception {

		
		MainGameRoot root = new MainGameRoot();
		SceneManager.instantiateScenes();
		SceneManager.setPrimaryStage(primaryStage);
		Scene scene = new Scene(root, 1100, 750);
		primaryStage.setScene(scene);
		primaryStage.show();


	}


	public static void main(String[] args) {
		launch(args);
	}

}
