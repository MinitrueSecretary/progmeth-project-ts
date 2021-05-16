package gameelement.ctrlbutton;

import gameelement.GameStage;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class PlaceButton extends Button {

	public PlaceButton() {
		this.setText("Place");
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				GameStage.setPlacing(true);
			};
		});
	}
	

}
