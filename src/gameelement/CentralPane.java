package gameelement;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class CentralPane extends HBox {

	private Scoreboard scoreboard1;
	private Scoreboard scoreboard2;
	private ButtonPanel buttonpanel;
	public CentralPane() {
		super();
		this.setPrefHeight(250);
		this.setPrefWidth(150);
		
		
		scoreboard1 = new Scoreboard(1);
		scoreboard2 = new Scoreboard(2);
		buttonpanel = new ButtonPanel();
		this.getChildren().addAll(scoreboard1,buttonpanel,scoreboard2);
		this.setAlignment(Pos.CENTER);
		
	}
	
}
