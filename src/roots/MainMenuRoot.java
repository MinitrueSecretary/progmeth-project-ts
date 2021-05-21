package roots;

import gameelement.MainMenuButton;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import logic.SceneManager;
import scene.SceneManager0;
import scene.VictoryScene;

public class MainMenuRoot extends AnchorPane {
	
	private  VBox buttonBox;
	private  MainMenuButton playButton;
	private  MainMenuButton htpButton;
	private  MainMenuButton exitButton;
	private  AudioClip bgMusic;
	
	public MainMenuRoot() {
		super();
		this.setPrefSize(1100, 750);
		String img_path = ClassLoader.getSystemResource("MainMenuBG.png").toString();
		this.setBackground(new Background(new BackgroundImage(new Image(img_path), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT 
				, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT )));
		
		playButton = new MainMenuButton("Play");
		htpButton = new MainMenuButton("How To Play");
		exitButton = new MainMenuButton("Exit");
		setupButtonEvent();
		buttonBox = new VBox(40, playButton, htpButton,exitButton);
		this.getChildren().add(buttonBox);
		AnchorPane.setRightAnchor(buttonBox, 40d);
		AnchorPane.setBottomAnchor(buttonBox, 80d);
		
		bgMusic = new AudioClip(ClassLoader.getSystemResource("sound/MainMenuBGM.mp3").toString());
		bgMusic.setVolume(0.1);
		bgMusic.play();
	}
	
	private void setupButtonEvent() {
		//TODO uncomment when mainGame is completed
		playButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				//SceneManager.setScene(SceneManager.getMainGame());
				SceneManager.setScene(SceneManager.getVictoryScene());
				bgMusic.stop();
				((VictoryRoot) SceneManager.getVictorySceneR()).playBGMusic();
			}
		});
		
		htpButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				SceneManager.setScene(SceneManager.getHowToPlay());
				//System.out.println("To How to play");
			}
		});
		
		exitButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				System.exit(0);
			}
		});
	}
	
	public void playBGMusic() {
		bgMusic.play();
	}
	
}
