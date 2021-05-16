package testarea;

import gameelement.PlayZone;
import gameelement.SelectPanel;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestingGrounds4 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		PlayZone pz = new PlayZone();
		Node bp = new GridPane();
		Node up = new SelectPanel();
		VBox root = new VBox();
		root.getChildren().addAll(pz,up);
		Scene scene = new Scene(root, 1000, 500);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
