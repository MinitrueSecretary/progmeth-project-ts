package gameelement.ctrlbutton;

import base.ControlButton;
import gameelement.GameStage;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

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
