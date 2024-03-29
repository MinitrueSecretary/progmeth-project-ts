package gameelement;

import base.UtilPane;
import exception.ActionNotExistException;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class UtilityPane extends Canvas implements UtilPane{
	//this class is for non-interactive utility pane
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
		} catch (ActionNotExistException e) {
			this.drawDefaultBackground();
		}
	}

	public void drawDefaultBackground() {
		String image_path = ClassLoader.getSystemResource("UtilityPaneDefault.png").toString();
		Image bg = new Image(image_path);
		this.gc.drawImage(bg, 0, 0);
	}

	public void drawBlankBackground() {
		Image bg = UtilPane.image;
		this.gc.drawImage(bg, 0, 0);
	}

	public void drawText(String actionname) throws ActionNotExistException {
			gc.setFill(Color.WHITE);
			gc.setFont(new Font("Century", 60));
			gc.fillText(actionname, 80, 100);
			gc.setFont(new Font("Gill Sans", 40));
			String guide;
		switch (actionname) {
		case "Hide":
			guide = "Choose one stone to hide" ;
			gc.fillText(guide, 100, 150);
			break;
		case "Swap":
			guide = "Choose two stones to swap position.\n"
					+ "Note that swapped hidden stones will remain hidden." ;
			gc.fillText(guide, 100, 150);
			break;
		case "Peek":
			gc.setFont(new Font("Gill Sans", 30));
			guide = "Choose one stone to peek privately.\n"
					+ "the other player, please close your eyes for the duration of the peek.\n"
					+ "If you lost points in the last round, you can peek three stones." ;
			gc.fillText(guide, 100, 150);
			break;
		default:
			throw new ActionNotExistException();
		}
		
	
		
	}

}
