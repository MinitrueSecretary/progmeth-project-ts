package gameelement;

import gameelement.ctrlbutton.BoastButton;
import gameelement.ctrlbutton.ChallengeButton;
import gameelement.ctrlbutton.HideButton;
import gameelement.ctrlbutton.CancelButton;
import gameelement.ctrlbutton.PeekButton;
import gameelement.ctrlbutton.PlaceButton;
import gameelement.ctrlbutton.SwapButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import logic.GameController;

public class ButtonPanel extends GridPane {
	
	private Button cancelButton;
	private PlaceButton placeButton;
	private HideButton hideButton;
	private Button swapButton;
	private Button peekButton;
	private Button challengeButton;
	private Button boastButton;
	
	public ButtonPanel() {
		super();
		this.setPrefWidth(800);
		this.setBackground(new Background(new BackgroundFill(Color.rgb(0, 186, 255), null, null)));
		this.setBorder(new Border(new BorderStroke(Color.rgb(220, 20, 60), BorderStrokeStyle.SOLID, CornerRadii.EMPTY,  new BorderWidths(5))));
		
		initializeAllButtons();
		addButtonsToPane();
		
		this.setPadding(new Insets(10));
		this.setHgap(10);
		this.setVgap(10);
		this.setAlignment(Pos.CENTER);
		
	}
	
	private void initializeAllButtons() {
		cancelButton = new CancelButton();
		placeButton = new PlaceButton();
		hideButton = new HideButton();
		swapButton = new SwapButton();
		peekButton = new PeekButton();
		challengeButton = new ChallengeButton();
		boastButton = new BoastButton();
	}
	
	private void addButtonsToPane() {
		this.add(cancelButton, 0, 0);
		this.add(placeButton, 1, 0);
		this.add(hideButton, 2, 0);
		this.add(swapButton, 3, 0);
		this.add(peekButton, 1, 1);
		this.add(challengeButton, 2, 1);
		this.add(boastButton, 3, 1);
	}

	public void disableAllButtons() {
		for(Node b:this.getChildren()) {
			((Button)b).setDisable(true);
		}
		//cancel button is excluded
		cancelButton.setDisable(false);
	}
	public void enableAllButtons() {
		for(Node b:this.getChildren()) {
			((Button)b).setDisable(false);
		}
		if(GameController.getHiddenStones().size() == 0) {
			disablePeekAndChallenge();
		}
	}
	
	public void disablePeekAndChallenge() {
		peekButton.setDisable(true);
		challengeButton.setDisable(true);
	}
	public void enablePeekAndChallenge() {
		peekButton.setDisable(false);
		challengeButton.setDisable(false);
	}
	
	public Button getCancelButton() {
		return cancelButton;
	}

	public Button getPlaceButton() {
		return placeButton;
	}

	public HideButton getHideButton() {
		return hideButton;
	}

	public Button getSwapButton() {
		return swapButton;
	}

//	public Button getRemoveButton() {
//		return removeButton;
//	}

	public Button getPeekButton() {
		return peekButton;
	}

	public Button getChallengeButton() {
		return challengeButton;
	}

	public Button getBoastButton() {
		return boastButton;
	}
	

	
}
