package testarea;

import java.util.ArrayList;

import gameelement.ButtonPanel;
import gameelement.CentralPane;
import gameelement.PlayZone;
import gameelement.Scoreboard;
import gameelement.UtilityPaneChallenge;
import gameelement.UtilityPanePlace;
import gameelement.UtilityPaneShowdown;
import gameelement.StoneButton;
import gameelement.UtilityPaneBoast;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestingGrounds3 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		UtilityPaneChallenge root = new UtilityPaneChallenge();
    	Scene scene = new Scene(root, 1100, 300);
    	System.out.println(root.getChildren());
        primaryStage.setTitle("Main Window");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
