package testarea;

import java.util.ArrayList;

import gameelement.ButtonPanel;
import gameelement.PlayZone;
import gameelement.StoneButton;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestingGrounds3 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new ButtonPanel();
		ButtonPanel bp = (ButtonPanel) root;
		bp.getPauseButton().setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				System.out.println("Game Pause");
			}
		});
    	//root.getChildren().addAll(StoneButton.getAllStones());
    	
    	Scene scene = new Scene(root, 1000, 400);

        primaryStage.setTitle("Main Window");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
