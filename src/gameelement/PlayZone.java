package gameelement;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;

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



}
