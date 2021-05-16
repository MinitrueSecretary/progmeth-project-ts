package gameelement;

import java.util.ArrayList;

import javax.management.AttributeList;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class PlayZone extends GridPane {

	private ArrayList<StoneButton> stoneInPlay;
	
	public PlayZone() {
		super();
		this.setWidth(1000);
		this.setHeight(200);
		stoneInPlay = new ArrayList<>();
		Image img = new Image(ClassLoader.getSystemResource("PlayZone.png").toString());
		this.setBackground(new Background(new BackgroundImage(img, null, null, null, null)));
		for(int i = 0; i<8;i++) {
			Button c = new StonePlaceHolder() ;
			this.add(c, i, 0);
			PlayZone.setMargin(c, new Insets(1));
			PlayZone.setHalignment(c,HPos.CENTER);
			PlayZone.setValignment(c, VPos.CENTER);
			
		}
		this.setAlignment(Pos.CENTER);
		
		
		
	}
	

}
