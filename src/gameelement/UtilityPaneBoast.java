package gameelement;


import base.UtilPane;
import gameelement.ctrlbutton.ShowdownButton;
import gameelement.ctrlbutton.StealButton;
import gameelement.ctrlbutton.YieldButton;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameController;
import logic.GameStage;
import logic.TurnManager;

public class UtilityPaneBoast extends VBox implements UtilPane{

	private Button yieldButton;
	private Button showdownButton;
	private Button stealButton;
	private Text guide;
	private AudioClip buttonSFX;
	
	
	public UtilityPaneBoast() {
		super();
		this.setPrefHeight(300);
		this.setPrefWidth(1100);
		this.setPadding(new Insets(10));
	
		this.setBackground(UtilPane.background);
		this.setAlignment(Pos.CENTER_LEFT);

		guide = new Text("Boast : You claim to know all the stones in the Line.\n"
				+ "	    The other player, please react.");
		guide.setFont(new Font("Gill Sans", 35));
		guide.setFill(Color.WHITE);
		UtilityPanePlace.setMargin(guide, new Insets(0,50,10,20));
		this.getChildren().add(guide);
		
		buttonSFX = new AudioClip(ClassLoader.getSystemResource("sound/ButtonSFX.mp3").toString());
		buttonSFX.setVolume(0.3);
		yieldButton = new ControlButton("Yield");
		yieldButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {

				buttonSFX.play();
				TurnManager.interruptClock();
				if(GameController.isBoastStolen()) {
					TurnManager.yieldToStolenBoast();
				}
				else {
					TurnManager.yieldToBoast();
				}
				
				GameController.setBoastStolen(false);
				GameStage.setBoastingStage(false);
				TurnManager.alternateTurns();
			}
		});
		showdownButton = new ControlButton("Showdown");
		((ControlButton)showdownButton).setButtonStyleSmallFont();
		stealButton = new ControlButton("Steal");
		HBox reacts = new HBox();
		reacts.setPadding(new Insets(10));
		reacts.setAlignment(Pos.CENTER);
		HBox.setMargin(yieldButton, new Insets(0,40,0,40));
		HBox.setMargin(showdownButton, new Insets(0,40,0,40));
		HBox.setMargin(stealButton, new Insets(0,40,0,40));
		
		reacts.getChildren().addAll(yieldButton,showdownButton,stealButton);
		
		//TODO add tooltip for the buttons
		this.getChildren().add(reacts);
		
		//TODO add event for the other buttons.
		stealButton.setOnMouseClicked(new EventHandler<Event>() {
			//TODO add game logic to this
			@Override
			public void handle(Event arg0) {

				buttonSFX.play();
				GameController.setBoastStolen(true);
				TurnManager.interruptClock();
				stealButton.setDisable(true);
				guide.setText("Boast Stolen!: The boasted also claims to know all the stones!\n"
						+ "	    You must react, but cannot steal the boast back.");
				
			}
		});
	}

	
	//getters and setters
	public Button getYieldButton() {
		return yieldButton;
	}

	public void setYieldButton(YieldButton yieldButton) {
		this.yieldButton = yieldButton;
	}

	public Button getShowdownButton() {
		return showdownButton;
	}

	public void setShowdownButton(ShowdownButton showdownButton) {
		this.showdownButton = showdownButton;
	}

	public Button getStealButton() {
		return stealButton;
	}

	public void setStealButton(StealButton stealButton) {
		this.stealButton = stealButton;
	}
	
	public void setNotStolen() {
		
		stealButton.setDisable(false);
		guide.setText("Boast : You claim to know all the stones in the Line.\n"
				+ "	    The other player, please react.");
		
		 new Text();
	}
}
