package scene;

import gameelement.MainMenuButton;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;

public class MainMenuScene extends Scene {
	private static VBox buttonBox;
	private static MainMenuButton playButton;
	private static MainMenuButton htpButton;
	private static MainMenuButton exitButton;
	
	public MainMenuScene() {
		super(generateRoot(), 1100, 750);
		setButtonEvent();
	}


	public static AnchorPane generateRoot() {
		AnchorPane root = new AnchorPane();
		String img_path = ClassLoader.getSystemResource("MainMenuBG.png").toString();
		root.setBackground(new Background(new BackgroundImage(new Image(img_path), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT 
				, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT )));
		
		playButton = new MainMenuButton("Play");
		htpButton = new MainMenuButton("How To Play");
		exitButton = new MainMenuButton("Exit");
		
		buttonBox = new VBox(40, playButton, htpButton,exitButton);
		root.getChildren().add(buttonBox);
		AnchorPane.setRightAnchor(buttonBox, 40d);
		AnchorPane.setBottomAnchor(buttonBox, 80d);
		
		return root;
		
	}
	private void setButtonEvent() {
		//TODO uncomment when mainGame is completed
		playButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				//SceneManager.setScene(SceneManager.getMainGame());
				SceneManager.setScene(SceneManager.getVictoryScene());
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

}
