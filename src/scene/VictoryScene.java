package scene;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class VictoryScene extends Scene {

	private static Text WinnerName;
	
	public VictoryScene() {
		super(generateRoot(), 1100, 750);
		// TODO Auto-generated constructor stub
	}

	private static AnchorPane generateRoot() {
		AnchorPane root = new AnchorPane();
		String img_path = ClassLoader.getSystemResource("VictoryScreen.png").toString();
		root.setBackground(new Background(new BackgroundImage(new Image(img_path), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT 
				, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT )));
		
		WinnerName = getWinner();
		
		HBox hbox = new HBox(WinnerName);
		hbox.setPrefWidth(1100);
		hbox.setAlignment(Pos.CENTER);
		
		root.getChildren().add(hbox);
		AnchorPane.setTopAnchor(hbox, 300d);
		return root;
	}

	public static Text getWinner() {
		Text text =  new Text("Player 1");
		text.setFont(new Font("Century",100));
		text.setFill(Color.WHITE);
		return text;
	}
}
