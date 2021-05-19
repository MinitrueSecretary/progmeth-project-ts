package scene;

import gameelement.MainMenuButton;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class VictoryScene extends Scene {

	private static Text WinnerName;
	private static MainMenuButton toMenuButton;
	private static AudioClip bgMusic;
	
	public VictoryScene() {
		super(generateRoot(), 1100, 750);
		setButtonEvent();
		
		bgMusic = new AudioClip(ClassLoader.getSystemResource("sound/VictoryBGM.mp3").toString());
		bgMusic.setVolume(0.1);
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
		
		toMenuButton = new MainMenuButton("To Menu");
		
		root.getChildren().addAll(hbox,toMenuButton);

		AnchorPane.setTopAnchor(hbox, 300d);
		AnchorPane.setTopAnchor(toMenuButton, 500d);
		AnchorPane.setLeftAnchor(toMenuButton, 550-(toMenuButton.getPrefWidth()/2));
		return root;
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
				((MainMenuScene) SceneManager.getMainMenu()).playBGMusic();
			}
		});
	}


	public static void playBGMusic() {
		bgMusic.play();
	}


	public static void setBgMusic(AudioClip bgMusic) {
		VictoryScene.bgMusic = bgMusic;
	}

}
