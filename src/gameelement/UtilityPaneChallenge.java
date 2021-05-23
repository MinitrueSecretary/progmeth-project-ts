package gameelement;

import base.UtilPane;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameController;
import logic.GameStage;
import logic.TurnManager;

public class UtilityPaneChallenge extends GridPane implements UtilPane{
	
	public UtilityPaneChallenge() {
		this.setPrefHeight(300);
		this.setPrefWidth(1100);
		this.setBackground(UtilPane.background);
		this.setAlignment(Pos.CENTER);
		this.setHgap(5);
		this.setVgap(5);
		this.setPadding(new Insets(10));
		Text guide = new Text("Challenge : Select one of the stones below.\n"
				+ "		   The other player shall find it in the PlayZone.");
		guide.setFont(new Font("Gill Sans", 35));
		guide.setFill(Color.WHITE);
		this.add(guide, 0, 0, 8, 1);

		
		
		for(int i =0; i<8;i++) {
			StoneButton s = StoneButton.getAllStones().get(i);	
			s.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					if (GameStage.isChallengingStage()) {
						if(GameController.getGuessStone() == null) {
							disableAllButOne(s);
							GameController.setGuessStone(s);
							TurnManager.interruptClock();
						}
					}
				}
			});
			
			this.add(s, i, 1);
			Text t = new Text(s.getStone().toString());
			t.setFont(new Font("Gill Sans", 16));
			t.setFill(Color.WHITE);
			this.add(t, i, 2);
			UtilityPaneChallenge.setHalignment(s,HPos.CENTER);
			UtilityPaneChallenge.setHalignment(t,HPos.CENTER);
			
			
		}
		
	}
	

	public void disableAllButOne(StoneButton excluded) {
		for(Node n : this.getChildren()) {
			if(n.getClass() == StoneButton.class) {
				((StoneButton)n).setDisable(true);
				
				if(((StoneButton)n).equals(excluded)) {
					((StoneButton)n).setDisable(false);
				}
			}
			

		}
	}
	public void enableAllButtons() {
		for(Node n : this.getChildren()) {
			if(n.getClass() == StoneButton.class) {
				((StoneButton)n).setDisable(false);
			}
		}
	}
	
	public void disableNotHiddens() {
		for(Node n : this.getChildren()) {
			if(n.getClass() == StoneButton.class) {
				StoneButton s = (StoneButton) n;
				if(GameController.getHiddenStones().contains(s.getStone())) {
					s.setDisable(false);
				}
				else {
					s.setDisable(true);
				}
			}
		}
	}
}
