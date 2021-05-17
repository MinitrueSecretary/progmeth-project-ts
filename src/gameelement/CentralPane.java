package gameelement;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class CentralPane extends HBox {

	private Scoreboard scoreboard1;
	private Scoreboard scoreboard2;
	private ButtonPanel buttonpanel;
	public CentralPane() {
		super();
		this.setPrefHeight(250);
		this.setPrefWidth(150);
		this.setPadding(new Insets(10));
		
		scoreboard1 = new Scoreboard(1);
		scoreboard2 = new Scoreboard(2);
		buttonpanel = new ButtonPanel();
		this.getChildren().addAll(scoreboard1,buttonpanel,scoreboard2);
		this.setAlignment(Pos.CENTER);
		
	}
	
}
