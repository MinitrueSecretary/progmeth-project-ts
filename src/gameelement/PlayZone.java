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
	
	private static ArrayList<StonePlaceHolder> stoneInPlay;

	public PlayZone() {
		super();
		this.setWidth(1100);
		this.setHeight(200);
		this.setPadding(new Insets(40, 10, 40, 0));
		stoneInPlay = new ArrayList<>();
		Image img = new Image(ClassLoader.getSystemResource("PlayZone.png").toString());
		this.setBackground(new Background(new BackgroundImage(img, null, null, null, null)));
		deployPlaceHolders();
		this.setAlignment(Pos.CENTER);
		this.unhighlightAllPlaceHolders();
	}

	public void deployPlaceHolders() {
		for (int i = 0; i < 8; i++) {
			StonePlaceHolder c = new StonePlaceHolder();
			// System.out.println(c.toString());
			stoneInPlay.add(c);
			if (c.getPlacingStone() != null) {
				System.out.println(c.getPlacingStone().getStoneName());
			}
		}

		for (int i = 0; i < 8; i++) {
			this.add((Node) stoneInPlay.get(i), i, 0);
		}

	}

	public static ArrayList<StonePlaceHolder> getStoneInPlay() {
		return stoneInPlay;
	}

	public static void setStoneInPlay(ArrayList<StonePlaceHolder> stoneInPlay) {
		PlayZone.stoneInPlay = stoneInPlay;
	}
	
	public void highlightAllPlaceHolders() {
		for(StonePlaceHolder s : stoneInPlay) {
			if(s.getPlacingStone() == null) {
				s.setVisible(true);
			}
		}
	}
	
	public void unhighlightAllPlaceHolders() {
		for(StonePlaceHolder s : stoneInPlay) {
			if(s.getPlacingStone() == null) {
				s.setVisible(false);
			}
		}
	}
	
	public ArrayList<Stone> getHiddenStones(){
		ArrayList<Stone> list = new ArrayList<>();
		for(StonePlaceHolder s: stoneInPlay) {
			if(s.isHidden()) {
				list.add(s.getPlacingStone());
			}
		}
		
		return list;
		
	}

//	public boolean placeStone(int index, StoneButton stoneButton) {
//		StonePlaceHolder s = stoneInPlay.get(index);
//		if (s.getClass() != StonePlaceHolder.class)
//			return false;
//		stoneInPlay.set(index, (StonePlaceHolder) stoneButton);
//		return true;
//	}
//
//	public StoneButton removeStone(int index) {
//		StonePlaceHolder s = stoneInPlay.get(index);
//		if (s.getClass() != StoneButton.class) {
//			stoneInPlay.set(index, (StonePlaceHolder) new StonePlaceHolder());
//			return (StoneButton) s;
//		}
//		return null;
//	}

}
