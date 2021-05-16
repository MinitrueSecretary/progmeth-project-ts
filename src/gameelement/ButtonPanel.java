package gameelement;

import gameelement.ctrlbutton.BoastButton;
import gameelement.ctrlbutton.ChallengeButton;
import gameelement.ctrlbutton.HideButton;
import gameelement.ctrlbutton.PauseButton;
import gameelement.ctrlbutton.PeakButton;
import gameelement.ctrlbutton.PlaceButton;
import gameelement.ctrlbutton.RemoveButton;
import gameelement.ctrlbutton.SwapButton;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

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
		initializeAllButtons();
		addButtonsToPane();
	}
	
	private void initializeAllButtons() {
		pauseButton = new PauseButton();
		placeButton = new PlaceButton();
		hideButton = new HideButton();
		swapButton = new SwapButton();
		removeButton = new RemoveButton();
		peakButton = new PeakButton();
		challengeButton = new ChallengeButton();
		boastButton = new BoastButton();
	}
	
	private void addButtonsToPane() {
		this.add(pauseButton, 0, 0);
		this.add(placeButton, 1, 0);
		this.add(hideButton, 2, 0);
		this.add(swapButton, 3, 0);
		this.add(removeButton, 0, 1);
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

	public Button getRemoveButton() {
		return removeButton;
	}

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
