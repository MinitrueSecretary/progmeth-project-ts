package roots;

import gameelement.ButtonPanel;
import gameelement.CentralPane;
import gameelement.PlayZone;
import gameelement.UtilityCorrectOrWrong;
import gameelement.UtilityPane;
import gameelement.UtilityPaneBoast;
import gameelement.UtilityPaneChallenge;
import gameelement.UtilityPanePlace;
import gameelement.UtilityPaneShowdown;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import logic.GameController;
import logic.GameStage;
import logic.TurnManager;

public class MainGameRoot extends VBox {
	
	private PlayZone pz;
	private CentralPane cp;
	
	private UtilityPane defaultPane;
	private UtilityPanePlace place;
	private UtilityPane hide;
	private UtilityPane swap;
	private UtilityPane peek;
	private UtilityPaneChallenge challenge;
	private UtilityPaneBoast boast;
	private UtilityPaneShowdown showdown;
	
	public MainGameRoot() {
		super();
		pz = new PlayZone();
		cp = new CentralPane();
		
		defaultPane = new UtilityPane();
		place = new UtilityPanePlace();
		hide = new UtilityPane("Hide");
		swap = new UtilityPane("Swap");
		peek = new UtilityPane("Peek");
		challenge = new UtilityPaneChallenge();
		boast = new UtilityPaneBoast();
		showdown = new UtilityPaneShowdown();
		this.getChildren().addAll(pz, cp, defaultPane);
		
		GameController.setUtilityPaneShowdown(showdown);
		GameController.setCentralPane(cp);
		GameController.setUtilityPaneBoast(boast);
		GameController.setUtilityPaneChallenge(challenge);
		GameController.setPlayzone(pz);
		setupButtons();
		TurnManager.initiate(this);
	}

	private void setupButtons() {
		Button placeButton = cp.getButtonpanel().getPlaceButton();
		Button hideButton = cp.getButtonpanel().getHideButton();
		Button swapbutton =  cp.getButtonpanel().getSwapButton();
		Button peekbutton = cp.getButtonpanel().getPeekButton();
		Button challButton = cp.getButtonpanel().getChallengeButton();
		Button boastButton = cp.getButtonpanel().getBoastButton();
		Button pauseButton = cp.getButtonpanel().getPauseButton();
		Button showdownButton = boast.getShowdownButton();
		
		cp.getButtonpanel().disablePeekAndChallenge();
		
		pauseButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				/*setUtilPane(defaultPane);
				cp.getButtonpanel().enableAllButtons();*/
				
				System.exit(0);
				
			}
		});
		
		placeButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
//				System.out.println("Clicked");
				GameStage.setPlacing(true);
				setUtilPane(place);
				cp.getButtonpanel().disableAllButtons();
			}
		});
		

		hideButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				GameStage.setHidingStage(true);
				setUtilPane(hide);
				cp.getButtonpanel().disableAllButtons();
			}
		});
		
		swapbutton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				GameStage.setSwapingStage(true);
				setUtilPane(swap);
				cp.getButtonpanel().disableAllButtons();
			}
		});
		
		peekbutton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				GameStage.setPeekingStage(true);
				setUtilPane(peek);
				cp.getButtonpanel().disableAllButtons();
			}
		});
		challButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
//				System.out.println("Clicked");
				GameStage.setChallengingStage(true);
				setUtilPane(challenge);
				cp.getButtonpanel().disableAllButtons();
				challenge.disableNotHiddens();
			}
		});
		
		boastButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				GameController.setBoastStolen(false);
				GameStage.setBoastingStage(true);
				setUtilPane(boast);
				cp.getButtonpanel().disableAllButtons();
				TurnManager.getCurrentPlayerScoreboard().getTimerThread().interrupt();

			}
		});
		
		showdownButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				GameStage.setShowdownStage(true);
				setUtilPane(showdown);
				cp.getButtonpanel().disableAllButtons();
				showdown.disableNotHiddens();
				TurnManager.getCurrentPlayerScoreboard().getTimerThread().interrupt();
				TurnManager.startShowdown();
				if(GameController.getHiddenStones().size() == 0) {
					TurnManager.showdownComplete();
				}
			}
		});
		
	}
	
	public void setUtilPane(Node n) {
		this.getChildren().set(2, n);
	}
	
	public void setUtilPane() {
		this.getChildren().set(2,defaultPane);
	}
	
	public void enableCPButtons() {
		cp.getButtonpanel().enableAllButtons();
	}


}
