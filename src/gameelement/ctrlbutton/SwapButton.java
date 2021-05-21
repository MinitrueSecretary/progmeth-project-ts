package gameelement.ctrlbutton;

import base.ControlButton;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import logic.GameStage;

public class SwapButton extends ControlButton {
	public SwapButton() {
		this.setText("Swap");
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				GameStage.setPlacing(true);
			};
		});
	}
}
