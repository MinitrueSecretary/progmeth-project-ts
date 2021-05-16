package gameelement;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class SwapButton extends Button {
	public SwapButton() {
		this.setText("Swap");
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				GameStage.setPlacing(true);
			};
		});
	}
}
