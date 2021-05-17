package gameelement;

import exception.ButtonNotExistException;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class UtilityPane extends Canvas {

	private GraphicsContext gc;

	public UtilityPane() {
		super(1100, 300);
		gc = this.getGraphicsContext2D();
		this.drawDefaultBackground();
	}

	public UtilityPane(String buttonname) {
		super(1100, 300);
		gc = this.getGraphicsContext2D();
		this.drawBlankBackground();

		try {
			this.drawText(buttonname);
		} catch (ButtonNotExistException e) {

		}
	}

	public void drawDefaultBackground() {
		String image_path = ClassLoader.getSystemResource("UtilityPaneDefault.png").toString();
		Image bg = new Image(image_path);
		this.gc.drawImage(bg, 0, 0);
	}

	public void drawBlankBackground() {
		String image_path = ClassLoader.getSystemResource("UtilityPaneBlank.png").toString();
		Image bg = new Image(image_path);
		this.gc.drawImage(bg, 0, 0);
	}

	public void drawText(String buttonname) throws ButtonNotExistException {
			gc.setFill(Color.WHITE);
			gc.setFont(new Font("Century", 60));
			gc.fillText(buttonname, 80, 100);
			gc.setFont(new Font("Gill Sans", 40));
			String guide;
		switch (buttonname) {
		case "Hide":
			guide = "Choose one stone to hide" ;
			gc.fillText(guide, 100, 150);
			break;
		case "Swap":
			guide = "Choose two stones to swap position.\n"
					+ "Note that swapped hideen stones will remain hidden." ;
			gc.fillText(guide, 100, 150);
			break;
		case "Peak":
			gc.setFont(new Font("Gill Sans", 30));
			guide = "Choose one stone to peak privately.\n"
					+ "the other player, please close your eyes for the duration of the peak.\n"
					+ "If you lost points in the last round, you can peak three stones." ;
			gc.fillText(guide, 100, 150);
			break;
		default:
			throw new ButtonNotExistException();
		}
		
	
		
	}

}
