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


public class MainMenuRoot extends AnchorPane {
	
	private VBox buttonBox;
	private MainMenuButton playButton;
	private MainMenuButton htpButton;
	private MainMenuButton exitButton;
	private static AudioClip bgMusic;
	private static AudioClip buttonSFX;
	
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
		
		buttonSFX = new AudioClip(ClassLoader.getSystemResource("sound/ButtonSFX.mp3").toString());
		buttonSFX.setVolume(0.3);
		bgMusic = new AudioClip(ClassLoader.getSystemResource("sound/MainMenuBGM.mp3").toString());
		bgMusic.setVolume(0.1);
		bgMusic.play();
	}
	
	private void setupButtonEvent() {
		playButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				buttonSFX.play();
				SceneManager.instatiateMainGame();
				SceneManager.setScene(SceneManager.getMainGame());
				bgMusic.stop();
				
				MainGameRoot.playBGMusic();
				
			}
		});
		
		htpButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				buttonSFX.play();
				SceneManager.setScene(SceneManager.getHowToPlay());
				//System.out.println("To How to play");
			}
		});
		
		exitButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				buttonSFX.play();
				System.exit(0);
			}
		});
	}
	
	public static void playBGMusic() {
		bgMusic.play();
	}
	
}
