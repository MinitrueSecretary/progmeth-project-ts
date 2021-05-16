package gameelement;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class RemoveButton extends Button {

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
