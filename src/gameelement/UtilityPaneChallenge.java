package gameelement;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameController;
import logic.GameStage;
import logic.TurnManager;

public class UtilityPaneChallenge extends GridPane {
	
	public UtilityPaneChallenge() {
		this.setPrefHeight(300);
		this.setPrefWidth(1100);
		String bgpath = ClassLoader.getSystemResource("UtilityPaneBlank.png").toString();
		this.setBackground(new Background(new BackgroundImage(new Image(bgpath), null, null, null, null)));
		this.setAlignment(Pos.CENTER);
		this.setHgap(5);
		this.setVgap(5);
		this.setPadding(new Insets(10));
		Text guide = new Text("Challenge : Select one of the stones below.\n"
				+ "		   The other player shall find it in the PlayZone.");
		guide.setFont(new Font("Gill Sans", 35));
		guide.setFill(Color.WHITE);
		this.add(guide, 0, 0, 8, 1);
		//TODO only hidden stones' buttons should be enabled.
		
		
		for(int i =0; i<8;i++) {
			StoneButton s = StoneButton.getAllStones().get(i);	
			s.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					if (GameStage.isChallengingStage()) {
						GameController.setGuessStone(s);
						disableAllButOne(s);
						TurnManager.getCurrentPlayerScoreboard().getTimerThread().interrupt();
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
			
		this.setAlignment(Pos.CENTER);
			
		}
		
	}
	
	public void unhighlightAllButtons() {
		for(Node n : this.getChildren()) {
			if(n.getClass() == StoneButton.class) {
				((StoneButton)n).unhighlight();
			}
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
}
