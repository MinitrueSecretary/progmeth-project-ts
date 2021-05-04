package gameelement;


import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StoneButton extends Button {
	private Stone stone;
	private final int SIZE;
	
	public StoneButton(String stoneName) {
		this.stone = new Stone(stoneName);
		this.SIZE = 100;
		ImageView image = new ImageView(stone.getUrl());
		image.setFitHeight(80);
		image.setFitWidth(80);
		this.setGraphic(image);
		this.setBackground(new Background(new BackgroundFill(Color.MIDNIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setPadding(new Insets(10));
		
		this.setTooltipandHighlight();
	}
	
	public void setTooltipandHighlight() {
		Tooltip	tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		tooltip.setText(stone.getStoneName());
		
		this.setOnMouseEntered((MouseEvent e) -> {
			highlight();
		});
		
		this.setOnMouseMoved((MouseEvent e) -> {
			if (stone != null)
			tooltip.show(this, e.getScreenX(), e.getScreenY()+10);
		});

		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
			unhighlight();
		});
		
		
		}
	public void highlight() {
		this.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
		changeIMG(96);
	}
	
	public void unhighlight() {
		this.setBackground(new Background(new BackgroundFill(Color.MIDNIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		changeIMG(80);
	}
	
	private void changeIMG(int size) {
		ImageView image = new ImageView(stone.getUrl());
		image.setFitHeight(size);
		image.setFitWidth(size);
		this.setGraphic(image);
		this.setPadding(new Insets((this.SIZE-size)/2));
		//System.out.println("size =" + size);
	}
	
	public static ArrayList<StoneButton> getAllStones(){
		ArrayList<StoneButton> allStones = new ArrayList<>();
		allStones.add(new StoneButton("Aircraft"));
		allStones.add(new StoneButton("Car"));
		allStones.add(new StoneButton("Chip"));
		allStones.add(new StoneButton("Factory"));
		allStones.add(new StoneButton("Flask"));
		allStones.add(new StoneButton("Gear"));
		allStones.add(new StoneButton("HardHat"));
		allStones.add(new StoneButton("Lightbulb"));
		return allStones;
	}
}
