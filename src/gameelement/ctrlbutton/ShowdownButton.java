package gameelement.ctrlbutton;

import base.ControlButton;

public class ShowdownButton extends ControlButton {

	public ShowdownButton() {
		super();
		this.setText("Showdown");
		super.setChallengeButtonStyle();
		//160px is not wide enough for Showdown button
		super.setPrefSize(170, 70);
	}

}
