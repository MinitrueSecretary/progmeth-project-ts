package gameelement;

import java.util.ArrayList;

import javax.management.AttributeList;

import base.Selectable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class PlayZone extends GridPane {

	private ArrayList<Selectable> stoneInPlay;
	
	public PlayZone() {
		super();
		this.setWidth(1000);
		this.setHeight(200);
		this.setPadding(new Insets(40,10,40,0));
		stoneInPlay = new ArrayList<>();
		Image img = new Image(ClassLoader.getSystemResource("PlayZone.png").toString());
		this.setBackground(new Background(new BackgroundImage(img, null, null, null, null)));
		deployPlaceHolders();
		this.setAlignment(Pos.CENTER);
	}
	
	public void deployPlaceHolders() {
		for(int i = 0; i<8;i++) {
			Button c = new StonePlaceHolder() ;
			stoneInPlay.add((Selectable) c);
			((StonePlaceHolder) c).highlight();	
		}
		for(int i = 0;i<8;i++) {
			this.add((Node) stoneInPlay.get(i), i, 0);
		}
		
	}
	
	public boolean placeStone(int index,StoneButton stoneButton) {
		Selectable s = stoneInPlay.get(index);
		if(s.getClass() != StonePlaceHolder.class)
			return false;
		stoneInPlay.set(index, (Selectable) stoneButton);
		return true;
	}
	public StoneButton removeStone(int index) {
		Selectable s = stoneInPlay.get(index);
		if(s.getClass() != StoneButton.class) {
			stoneInPlay.set(index, (Selectable) new StonePlaceHolder());
			return (StoneButton) s;
		}
		return null;
	}

}
