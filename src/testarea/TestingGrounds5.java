package testarea;

import gameelement.ButtonPanel;
import gameelement.PlayZone;
import gameelement.SelectPanel;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestingGrounds5 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		ButtonPanel bp = new ButtonPanel();
		VBox root = new VBox();
		root.getChildren().addAll(bp);
		Scene scene = new Scene(root, 1100, 500);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
