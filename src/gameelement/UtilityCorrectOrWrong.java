package gameelement;

import gameelement.ctrlbutton.CorrectButton;
import gameelement.ctrlbutton.ShowdownButton;
import gameelement.ctrlbutton.StealButton;
import gameelement.ctrlbutton.WrongButton;
import gameelement.ctrlbutton.YieldButton;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class UtilityCorrectOrWrong extends VBox {

	private CorrectButton correctButton;
	private WrongButton wrongButton;

	public UtilityCorrectOrWrong() {
		super();
		this.setPrefHeight(300);
		this.setPrefWidth(1100);
		this.setPadding(new Insets(10));

		String bgpath = ClassLoader.getSystemResource("UtilityPaneBlank.png").toString();
		this.setBackground(new Background(new BackgroundImage(new Image(bgpath), null, null, null, null)));
		this.setAlignment(Pos.CENTER_LEFT);

		Text guide = new Text(
				"It's show time! : If your opponent can guess all hidden stone.\n"
						+ "                          He/She win this game. If not, you will win");
		guide.setFont(new Font("Gill Sans", 35));
		guide.setFill(Color.WHITE);
		UtilityPanePlace.setMargin(guide, new Insets(0, 50, 10, 20));
		this.getChildren().add(guide);

		correctButton = new CorrectButton();
		correctButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				// this guy win
			}
		});
		wrongButton = new WrongButton();
		wrongButton.setOnMouseClicked(new EventHandler<MouseEvent>() {@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			// opponent win
		}
		});
		HBox reacts = new HBox();
		reacts.setPadding(new Insets(10));
		reacts.setAlignment(Pos.CENTER);
		HBox.setMargin(correctButton, new Insets(0, 50, 0, 50));
		HBox.setMargin(wrongButton, new Insets(0, 50, 0, 50));

		reacts.getChildren().addAll(correctButton, wrongButton);

		// TODO add tooltip for the buttons
		this.getChildren().add(reacts);

	}
}
