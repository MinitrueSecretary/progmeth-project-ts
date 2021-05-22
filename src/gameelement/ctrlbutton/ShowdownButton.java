package gameelement.ctrlbutton;

import base.ControlButton;
import logic.GameController;
import logic.GameStage;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ShowdownButton extends ControlButton {

	public ShowdownButton() {
		super();
		this.setText("Showdown");
		super.setChallengeButtonStyle();
		//160px is not wide enough for Showdown button
		super.setPrefSize(170, 70);
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				GameStage.setShowdownStage(true);
			}
		});
	}

}
