package gameelement;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class HideButton extends Button {

	public HideButton() {
		this.setText("Hide");
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				GameStage.setHidingStage(true);
			};
		});
	}
}
