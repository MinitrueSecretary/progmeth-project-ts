package gameelement.ctrlbutton;

import base.ControlButton;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import logic.GameStage;

public class PauseButton extends ControlButton {

	public PauseButton() {
		this.setText("Pause");
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				switch (PauseButton.this.getText()) {
				case "Pause": {
					GameStage.setPausingStage(true);
					PauseButton.this.setText("Resume");
					break;
				}
				case "Resume": {
					GameStage.setPausingStage(false);
					PauseButton.this.setText("Pause");
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + PauseButton.this);
				}
			}
		});

	}
}
