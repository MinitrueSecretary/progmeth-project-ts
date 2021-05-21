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
import logic.SceneManager;
import scene.MainMenuScene;
import scene.SceneManager0;

public class VictoryRoot extends AnchorPane {
	
	private Text WinnerName;
	private MainMenuButton toMenuButton;
	private AudioClip bgMusic;
	
	public VictoryRoot() {
		super();
		String img_path = ClassLoader.getSystemResource("VictoryScreen.png").toString();
		this.setBackground(new Background(new BackgroundImage(new Image(img_path), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT 
				, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT )));
		
		WinnerName = getWinner();
		
		HBox hbox = new HBox(WinnerName);
		hbox.setPrefWidth(1100);
		hbox.setAlignment(Pos.CENTER);
		
		toMenuButton = new MainMenuButton("To Menu");
		setButtonEvent();
		
		this.getChildren().addAll(hbox,toMenuButton);

		AnchorPane.setTopAnchor(hbox, 300d);
		AnchorPane.setTopAnchor(toMenuButton, 500d);
		AnchorPane.setLeftAnchor(toMenuButton, 550-(toMenuButton.getPrefWidth()/2));
		
		bgMusic = new AudioClip(ClassLoader.getSystemResource("sound/VictoryBGM.mp3").toString());
		bgMusic.setVolume(0.1);
	}
	public static Text getWinner() {
		Text text =  new Text("Player 1");
		text.setFont(new Font("Century",100));
		text.setFill(Color.WHITE);
		return text;
	}
	
	private void setButtonEvent() {
		toMenuButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				SceneManager.setScene(SceneManager.getMainMenu());
				bgMusic.stop();
				((MainMenuRoot) SceneManager.getMainMenuR()).playBGMusic();
			}
		});
	}


	public void playBGMusic() {
		bgMusic.play();
	}

}
