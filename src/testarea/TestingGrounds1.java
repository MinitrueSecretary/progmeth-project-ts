package testarea;

import gameelement.SelectPanel;
import gameelement.StoneButton;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TestingGrounds1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new SelectPanel();
		
    	Scene scene = new Scene(root, 850, 400);

        primaryStage.setTitle("Main Window");
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
