package testarea;

import gameelement.StoneButton;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TestingGrounds1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FlowPane root = new FlowPane();
    	root.setPadding(new Insets(5));
    	root.setHgap(5);
    	root.setVgap(5);
    	
    	StoneButton airplaneButton = new StoneButton("Car");
    	
    	root.getChildren().add(airplaneButton);
        
        Scene scene = new Scene(root, 410, 400);

        primaryStage.setTitle("Main Window");
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
