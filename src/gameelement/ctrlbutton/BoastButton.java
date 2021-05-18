package gameelement.ctrlbutton;

import base.ControlButton;
import gameelement.ButtonPanel;
import gameelement.GameStage;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class BoastButton extends ControlButton{

	public BoastButton() {
		super();
		this.setText("Boast");
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			GameStage.setBoastingStage(true);
		}
		});
	}
}
