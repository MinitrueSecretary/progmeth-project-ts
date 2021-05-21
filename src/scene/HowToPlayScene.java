package scene;

import java.util.ArrayList;
import java.util.Iterator;

import gameelement.MainMenuButton;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HowToPlayScene extends Scene {

	private static ArrayList<Image> pages;
	private static ImageView page;
	
	private static HBox buttonBox;
	private static MainMenuButton prevButton;
	private static MainMenuButton nextButton;
	private static MainMenuButton toMenuButton;
	private static int pageNum = 0;
	private static VBox root;
	
	public HowToPlayScene() {
		super(root = generateRoot(),1100,750);
		setButtonEvent();
	}

	private static VBox generateRoot() {
		VBox root = new VBox();
		root.setPrefSize(1100, 750);
		root.setPadding(new Insets(30));
		String img_path = ClassLoader.getSystemResource("MainMenuBlank.png").toString();
		root.setBackground(new Background(new BackgroundImage(new Image(img_path), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT 
				, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));

		prevButton = new MainMenuButton("Previous");
		prevButton.setDisable(true);
		nextButton = new MainMenuButton("Next");
		toMenuButton = new MainMenuButton("To Menu");
		
		buttonBox = new HBox(40,prevButton,nextButton,toMenuButton);
		buttonBox.setAlignment(Pos.BASELINE_CENTER);
		buttonBox.setPadding(new Insets(40));
		
		pages = generatePages();
		page = new ImageView(pages.get(0));	
		
		
		root.getChildren().addAll(buttonBox,page);		
		root.setAlignment(Pos.CENTER);
		return root;
	}
	
	private static ArrayList<Image> generatePages(){
		ArrayList<Image> pages = new ArrayList<>();
		for(int i = 1;i<=6;i++) {
			String img_path = ClassLoader.getSystemResource
					("howtoplay/Page" + i +".png").toString();
			Image img = new Image(img_path);
			pages.add(img);
		}
		
		return pages;
		
	}
	private void setButtonEvent() {

		prevButton.setOnMouseClicked(new EventHandler<Event>() {
		
			@Override
			public void handle(Event arg0) {
				page = new ImageView(pages.get(--pageNum));
				root.getChildren().set(1, page);
				if(pageNum < 5) {
					nextButton.setDisable(false);
				}
				if(pageNum == 0) {
					prevButton.setDisable(true);
				}
				//System.out.println(pageNum);
				//System.out.println("Previous");
			}
		});
		
		nextButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				page = new ImageView(pages.get(++pageNum));
				root.getChildren().set(1, page);
				if(pageNum == 5) {
					nextButton.setDisable(true);
				}
				if(pageNum > 0) {
					prevButton.setDisable(false);
				}
				//System.out.println(pageNum);
				//System.out.println("Next");
			}
		});
		
		toMenuButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				SceneManager0.setScene(SceneManager0.getMainMenu());
				//System.out.println("To Main Menu");
			}
		});
	}

}
