package gameelement.ctrlbutton;

import base.ControlButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import logic.GameController;
import logic.GameStage;
import logic.TurnManager;

public class BoastButton extends ControlButton{

	public BoastButton() {
		super();
		this.setText("Boast");
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				System.out.println("Hello");
				GameController.setBoastStolen(false);
				GameStage.setBoastingStage(true);
				TurnManager.getCurrentPlayerScoreboard().getTimerThread().interrupt();
			}
		});
	}
}
