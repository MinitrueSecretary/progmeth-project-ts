package roots;

import gameelement.MainMenuButton;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.TurnManager;

public class VictoryRoot extends AnchorPane {
	
	private Text WinnerName;
	private MainMenuButton exitButton;
	private static AudioClip bgMusic;
	
	public VictoryRoot() {
		super();
		String img_path = ClassLoader.getSystemResource("VictoryScreen.png").toString();
		this.setBackground(new Background(new BackgroundImage(new Image(img_path), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT 
				, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT )));
		bgMusic = new AudioClip(ClassLoader.getSystemResource("sound/VictoryBGM.mp3").toString());
		bgMusic.setVolume(0.1);
		
		exitButton = new MainMenuButton("Exit");
		setButtonEvent();
		this.getChildren().add(exitButton);
		AnchorPane.setTopAnchor(exitButton, 500d);
		AnchorPane.setLeftAnchor(exitButton, 550-(exitButton.getPrefWidth()/2));

	}
	public static Text getWinner() {
		String winner;
		if(TurnManager.getWinner() == 1) {
			winner = "Player 1";
		}
		else {
			winner = "Player 2";
		}
		Text text =  new Text(winner);
		text.setFont(new Font("Century",100));
		text.setFill(Color.WHITE);
		return text;
	}
	
	public void declareWinner() {

		WinnerName = getWinner();
		
		HBox hbox = new HBox(WinnerName);
		hbox.setPrefWidth(1100);
		hbox.setAlignment(Pos.CENTER);

		this.getChildren().add(hbox);

		AnchorPane.setTopAnchor(hbox, 300d);

		
		playBGMusic();
		
	}
	
	private void setButtonEvent() {
		exitButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				
				bgMusic.stop();
				System.exit(0);
				
			}
		});
	}


	public static void playBGMusic() {
		bgMusic.play();
	}

}
