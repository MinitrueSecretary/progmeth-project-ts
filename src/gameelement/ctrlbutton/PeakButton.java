package gameelement.ctrlbutton;

import base.ControlButton;
import gameelement.GameStage;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class PeakButton extends ControlButton {
	public PeakButton() {
		this.setText("Peak");
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			GameStage.setPeakingStage(true);
		}
		});
	}
}
