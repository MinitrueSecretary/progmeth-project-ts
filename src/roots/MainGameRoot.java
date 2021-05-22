package roots;

import gameelement.CentralPane;
import gameelement.PlayZone;
import gameelement.UtilityPane;
import gameelement.UtilityPaneBoast;
import gameelement.UtilityPaneChallenge;
import gameelement.UtilityPanePlace;
import gameelement.UtilityPaneShowdown;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
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
	
	private static AudioClip bgMusic;
	private static AudioClip buttonSFX;
	private static AudioClip showdownBGM;
	
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
		
		buttonSFX = new AudioClip(ClassLoader.getSystemResource("sound/ButtonSFX.mp3").toString());
		buttonSFX.setVolume(0.3);
		bgMusic = new AudioClip(ClassLoader.getSystemResource("sound/GameBGM.mp3").toString());
		bgMusic.setVolume(0.1);
		showdownBGM = new AudioClip(ClassLoader.getSystemResource("sound/ShowdownBGM.wav").toString());
		showdownBGM.setVolume(0.1);
		
		
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
		Button cancelButton = cp.getButtonpanel().getCancelButton();
		Button showdownButton = boast.getShowdownButton();
		
		cp.getButtonpanel().disablePeekAndChallenge();
		
		cancelButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				buttonSFX.play();
				GameStage.setAllToFalse();
				setUtilPane(defaultPane);
				cp.getButtonpanel().enableAllButtons();
					
			}
		});
		
		placeButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				buttonSFX.play();
//				System.out.println("Clicked");
				GameStage.setPlacing(true);
				setUtilPane(place);
				cp.getButtonpanel().disableAllButtons();
			}
		});
		

		hideButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				buttonSFX.play();
				GameStage.setHidingStage(true);
				setUtilPane(hide);
				cp.getButtonpanel().disableAllButtons();
			}
		});
		
		swapbutton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				buttonSFX.play();
				GameStage.setSwapingStage(true);
				setUtilPane(swap);
				cp.getButtonpanel().disableAllButtons();
			}
		});
		
		peekbutton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				buttonSFX.play();
				GameStage.setPeekingStage(true);
				setUtilPane(peek);
				cp.getButtonpanel().disableAllButtons();
			}
		});
		challButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				buttonSFX.play();
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
				buttonSFX.play();
				GameController.setBoastStolen(false);
				GameStage.setBoastingStage(true);
				setUtilPane(boast);
				cp.getButtonpanel().disableAllButtons();
				cp.getButtonpanel().getCancelButton().setDisable(true);
				TurnManager.getCurrentPlayerScoreboard().getTimerThread().interrupt();

			}
		});
		
		showdownButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				buttonSFX.play();
				bgMusic.stop();
				showdownBGM.play();
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
	
	public static void playBGMusic() {
		bgMusic.play();
	}
	
	public static AudioClip getBGMusic() {
		return bgMusic;
	}
	
	public static AudioClip getButtonSFX() {
		return buttonSFX;
	}


	public static AudioClip getShowdownBGM() {
		return showdownBGM;
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
