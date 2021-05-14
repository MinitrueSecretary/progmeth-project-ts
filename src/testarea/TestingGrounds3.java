package testarea;

import java.util.ArrayList;

import gameelement.PlayZone;
import gameelement.StoneButton;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestingGrounds3 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new PlayZone();
    	root.setPadding(new Insets(10));
    	//root.getChildren().addAll(StoneButton.getAllStones());
    	
    	Scene scene = new Scene(root, 1000, 200);

        primaryStage.setTitle("Main Window");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
