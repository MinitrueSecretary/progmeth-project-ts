package gameelement.ctrlbutton;

import base.ControlButton;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import logic.GameStage;

public class RemoveButton extends ControlButton {

	public RemoveButton() {
		this.setText("Remove");
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			GameStage.setRemovingStage(true);
		}
		});
	}
}
