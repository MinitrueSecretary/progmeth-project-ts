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

public class UtilityPaneShowdown extends GridPane implements UtilPane{

	public UtilityPaneShowdown() {
		super();
		this.setPrefHeight(300);
		this.setPrefWidth(1100);
		this.setBackground(UtilPane.background);
		this.setAlignment(Pos.CENTER);
		this.setHgap(5);
		this.setVgap(5);
		this.setPadding(new Insets(10));
		Text guide = new Text("SHOWDOWN! : Match the stones below with the ones above.\n"
				+ "		   Get it all right, you win. If not, you lose.");
		guide.setFont(new Font("Gill Sans", 35));
		guide.setFill(Color.WHITE);
		this.add(guide, 0, 0, 8, 1);
		
		
		
		for(int i =0; i<8;i++) {
			StoneButton s = StoneButton.getAllStones().get(i);	
			s.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					if (GameStage.isShowdownStage()) {
						GameController.setGuessStone(s);
						disableAllButOne(s);
					}
				}
			});
			
			this.add(s, i, 1);
			Text t = new Text(s.getStone().toString());
			t.setFont(new Font("Gill Sans", 16));
			t.setFill(Color.WHITE);
			this.add(t, i, 2);
			GridPane.setHalignment(s,HPos.CENTER);
			GridPane.setHalignment(t,HPos.CENTER);
			
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
