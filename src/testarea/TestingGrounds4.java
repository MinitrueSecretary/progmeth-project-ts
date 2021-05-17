package testarea;

import gameelement.ButtonPanel;
import gameelement.CentralPane;
import gameelement.PlayZone;
import gameelement.SelectPanel;
import gameelement.UtilityPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestingGrounds4 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		PlayZone pz = new PlayZone();
		Node bp = new CentralPane();
		Node up = new UtilityPane();
		VBox root = new VBox();
		root.getChildren().addAll(pz,bp,up);
		Scene scene = new Scene(root, 1100, 750);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
