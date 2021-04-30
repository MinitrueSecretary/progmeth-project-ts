package gameelement;


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
	
	public StoneButton(String stoneName) {
		// TODO Auto-generated constructor stub
		this.setPadding(new Insets(5));
		this.stone = new Stone(stoneName);
		ImageView image = new ImageView(stone.getUrl());
		image.setFitHeight(48);
		image.setFitWidth(48);
		this.setGraphic(image);
		
		this.setBackground(new Background(new BackgroundFill(Color.MIDNIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.setTooltip();
	}
	
	public void setTooltip() {
		Tooltip	tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		tooltip.setText(stone.getStoneName());
		this.setOnMouseMoved((MouseEvent e) -> {
			if (stone != null)
			tooltip.show(this, e.getScreenX(), e.getScreenY()+10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});		
	}
}
