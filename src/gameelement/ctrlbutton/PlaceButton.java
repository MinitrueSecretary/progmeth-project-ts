package gameelement.ctrlbutton;

import base.ControlButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import logic.GameStage;

public class PlaceButton extends ControlButton {

	public PlaceButton() {
		this.setText("Place");
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				GameStage.setPlacing(true);
			};
		});
	}
	

}
