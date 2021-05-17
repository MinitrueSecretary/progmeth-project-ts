package testarea;

import gameelement.UtilityPaneChallenge;
import gameelement.StoneButton;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TestingGrounds1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox();
		ObservableList<Node> rc = root.getChildren();
		root.setPadding(new Insets(10));
		StoneButton b = new StoneButton("Chip");
		StoneButton a = new StoneButton("Aircraft");
		root.getChildren().add(b);
		root.getChildren().add(a);
		
		root.setAlignment(Pos.CENTER);
		 b.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					rc.add(new StoneButton("LightBulb"));
				}
			});
	        a.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					rc.removeAll(rc);					
					
				}
			});
		/*GridPane root = new SelectPanel();
		Image img = new Image(ClassLoader.getSystemResource("PlayZone.png").toString());
		root.setBackground(new Background(new BackgroundImage(img, null, null, null, null)));*/
    	Scene scene = new Scene(root, 1000, 200);

        primaryStage.setTitle("Main Window");
        primaryStage.setScene(scene);
        primaryStage.show();
       
	}

	public static void main(String[] args) {
		launch(args);
	}

}
