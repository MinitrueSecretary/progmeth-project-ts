package gameelement;

import gameelement.ctrlbutton.BoastButton;
import gameelement.ctrlbutton.ChallengeButton;
import gameelement.ctrlbutton.HideButton;
import gameelement.ctrlbutton.PauseButton;
import gameelement.ctrlbutton.PeakButton;
import gameelement.ctrlbutton.PlaceButton;
import gameelement.ctrlbutton.RemoveButton;
import gameelement.ctrlbutton.SwapButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class ButtonPanel extends GridPane {
	
	private Button pauseButton;
	private PlaceButton placeButton;
	private HideButton hideButton;
	private Button swapButton;
	private Button removeButton;
	private Button peakButton;
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
		pauseButton = new PauseButton();
		placeButton = new PlaceButton();
		hideButton = new HideButton();
		swapButton = new SwapButton();
		//removeButton = new RemoveButton();
		peakButton = new PeakButton();
		challengeButton = new ChallengeButton();
		boastButton = new BoastButton();
	}
	
	private void addButtonsToPane() {
		this.add(pauseButton, 0, 0);
		this.add(placeButton, 1, 0);
		this.add(hideButton, 2, 0);
		this.add(swapButton, 3, 0);
		//this.add(removeButton, 0, 1);
		this.add(peakButton, 1, 1);
		this.add(challengeButton, 2, 1);
		this.add(boastButton, 3, 1);
	}

	
	public Button getPauseButton() {
		return pauseButton;
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

	public Button getPeakButton() {
		return peakButton;
	}

	public Button getChallengeButton() {
		return challengeButton;
	}

	public Button getBoastButton() {
		return boastButton;
	}
	

	
}
