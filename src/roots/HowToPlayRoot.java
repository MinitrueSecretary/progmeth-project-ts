package roots;

import java.util.ArrayList;
import java.util.List;

import gameelement.MainMenuButton;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.SceneManager;
import scene.SceneManager0;

public class HowToPlayRoot extends VBox {
	
	private ArrayList<Image> pages;
	private ImageView page;
	private HBox buttonBox;
	private MainMenuButton prevButton;
	private MainMenuButton nextButton;
	private MainMenuButton toMenuButton;
	private int pageNum = 0;
	private List<Node> children;
	public HowToPlayRoot() {
		super();
		this.setPrefSize(1100, 750);
		this.setPadding(new Insets(30));
		String img_path = ClassLoader.getSystemResource("MainMenuBlank.png").toString();
		this.setBackground(new Background(new BackgroundImage(new Image(img_path), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT 
				, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));

		prevButton = new MainMenuButton("Previous");
		prevButton.setDisable(true);
		nextButton = new MainMenuButton("Next");
		toMenuButton = new MainMenuButton("To Menu");
		setButtonEvent();
		
		buttonBox = new HBox(40,prevButton,nextButton,toMenuButton);
		buttonBox.setAlignment(Pos.BASELINE_CENTER);
		buttonBox.setPadding(new Insets(40));
		
		pages = generatePages();
		page = new ImageView(pages.get(0));	
		
		
		this.getChildren().addAll(buttonBox,page);
		children = this.getChildren();
		this.setAlignment(Pos.CENTER);
	}
	
	private  ArrayList<Image> generatePages(){
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
				children.set(1, page);
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
				children.set(1, page);
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
				SceneManager.setScene(SceneManager.getMainMenu());
				//System.out.println("To Main Menu");
			}
		});
	}



}
