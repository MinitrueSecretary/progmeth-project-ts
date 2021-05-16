package gameelement.ctrlbutton;

import gameelement.GameStage;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ChallengeButton extends Button{
	public ChallengeButton() {
		this.setText("Challenge");
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			GameStage.setChallengingStage(true);
		}
		});
	}
}
