package testarea;

import gameelement.ButtonPanel;
import gameelement.CentralPane;
import gameelement.PlayZone;
import gameelement.UtilityPane;
import gameelement.UtilityPaneBoast;
import gameelement.UtilityPaneChallenge;
import gameelement.UtilityPanePlace;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.GameStage;
import logic.TurnManager;

public class TestingGroundsB2 extends Application {
	private PlayZone pz;
	private CentralPane cp;
	private Node utilPane;

	private UtilityPane defaultPane;
	private UtilityPanePlace place;
	private UtilityPane hide;
	private UtilityPane swap;
	private UtilityPane peak;
	private UtilityPaneChallenge challenge;
	private UtilityPaneBoast boast;
	private VBox root;

	@Override
	public void start(Stage primaryStage) throws Exception {
		pz = new PlayZone();
		cp = new CentralPane();

		defaultPane = new UtilityPane();
		place = new UtilityPanePlace();
		hide = new UtilityPane("Hide");
		swap = new UtilityPane("Swap");
		peak = new UtilityPane("Peak");
		challenge = new UtilityPaneChallenge();
		boast = new UtilityPaneBoast();
		utilPane = defaultPane;
		System.out.println(utilPane);
		System.out.println(boast);

		root = new VBox();
		root.getChildren().addAll(pz, cp, utilPane);
		Scene scene = new Scene(root, 1100, 750);
		primaryStage.setScene(scene);
		primaryStage.show();

		setupButtons();
		TurnManager.initiate();

	}

	private void setupButtons() {
		Button boastButton = cp.getButtonpanel().getBoastButton();
		Button placeButtun = cp.getButtonpanel().getPlaceButton();
		Button challButton = cp.getButtonpanel().getChallengeButton();
		
		boastButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				System.out.println("Clicked");
				root.getChildren().set(2, boast);
			}
		});

		placeButtun.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
//				System.out.println("Clicked");
				GameStage.setPlacing(true);
				if (GameStage.isPlacing() == true) {
					root.getChildren().set(2, place);
				}
			}
		});
		
		challButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
//				System.out.println("Clicked");
				GameStage.setChallengingStage(true);
				if (GameStage.isChallengingStage() == true) {
					root.getChildren().set(2, challenge);
				}
			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}

	// getters

	public ButtonPanel getButtonPanel() {
		return cp.getButtonpanel();
	}

	public PlayZone getPZ() {
		return pz;
	}

	public CentralPane getCP() {
		return cp;
	}

	public Node getUtilPane() {
		return utilPane;
	}

}
