package gameelement;


import gameelement.ctrlbutton.ShowdownButton;
import gameelement.ctrlbutton.StealButton;
import gameelement.ctrlbutton.YieldButton;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameController;
import logic.GameStage;
import logic.TurnManager;

public class UtilityPaneBoast extends VBox {

	private YieldButton yieldButton;
	private ShowdownButton showdownButton;
	private StealButton stealButton;
	private Text guide;
	
	public UtilityPaneBoast() {
		super();
		this.setPrefHeight(300);
		this.setPrefWidth(1100);
		this.setPadding(new Insets(10));
		
		String bgpath = ClassLoader.getSystemResource("UtilityPaneBlank.png").toString();
		this.setBackground(new Background(new BackgroundImage(new Image(bgpath), null, null, null, null)));
		this.setAlignment(Pos.CENTER_LEFT);

		guide = new Text("Boast : You claim to know all the stones in the Line.\n"
				+ "	    The other player, please react.");
		guide.setFont(new Font("Gill Sans", 35));
		guide.setFill(Color.WHITE);
		UtilityPanePlace.setMargin(guide, new Insets(0,50,10,20));
		this.getChildren().add(guide);
		
		yieldButton = new YieldButton();
		yieldButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				TurnManager.getCurrentPlayerScoreboard().getTimerThread().interrupt();
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
		showdownButton = new ShowdownButton();
		stealButton = new StealButton();
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
				GameController.setBoastStolen(true);
				TurnManager.getCurrentPlayerScoreboard().getTimerThread().interrupt();
				stealButton.setDisable(true);
				guide.setText("Boast Stolen!: The boasted also claims to know all the stones!\n"
						+ "	    You must react, but cannot steal the boast back.");
				
			}
		});
	}

	
	//getters and setters
	public YieldButton getYieldButton() {
		return yieldButton;
	}

	public void setYieldButton(YieldButton yieldButton) {
		this.yieldButton = yieldButton;
	}

	public ShowdownButton getShowdownButton() {
		return showdownButton;
	}

	public void setShowdownButton(ShowdownButton showdownButton) {
		this.showdownButton = showdownButton;
	}

	public StealButton getStealButton() {
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
