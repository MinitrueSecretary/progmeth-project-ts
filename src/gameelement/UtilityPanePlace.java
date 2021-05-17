package gameelement;

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class UtilityPanePlace extends VBox {

	public UtilityPanePlace() {
		super();
		this.setPrefHeight(300);
		this.setPrefWidth(1100);
		this.setPadding(new Insets(10));
		
		String bgpath = ClassLoader.getSystemResource("UtilityPaneBlank.png").toString();
		this.setBackground(new Background(new BackgroundImage(new Image(bgpath), null, null, null, null)));
		this.setAlignment(Pos.CENTER_LEFT);

		Text guide = new Text("Place : These are stones which are not in play.\n"
				+ "	   Select one to place it in the PlayZone.");
		guide.setFont(new Font("Gill Sans", 35));
		guide.setFill(Color.WHITE);
		UtilityPanePlace.setMargin(guide, new Insets(0,40,10,20));
		this.getChildren().add(guide);
		

		HBox stoneBox = new StoneBox();
		this.getChildren().add(stoneBox);
	}

	// TODO stones in play must be removed

	class StoneBox extends HBox {

		public StoneBox() {
			super();
			this.setPrefWidth(1100);
			this.setPadding(new Insets(5));
			this.setAlignment(Pos.CENTER);

			this.getChildren().addAll(new ArrayList<>(StoneButton.getAllStones()));

		}

	}

}
