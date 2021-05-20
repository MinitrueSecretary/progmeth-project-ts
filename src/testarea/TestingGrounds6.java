package testarea;

import gameelement.CentralPane;
import gameelement.PlayZone;
import gameelement.UtilityPane;
import gameelement.UtilityPanePlace;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestingGrounds6 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		PlayZone pz = new PlayZone();
		Node bp = new CentralPane();
		Node up = new UtilityPanePlace();
		VBox root = new VBox();
		root.getChildren().addAll(pz, bp, up);
		Scene scene = new Scene(root, 1100, 750);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
