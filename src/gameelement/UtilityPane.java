package gameelement;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class UtilityPane extends ImageView {



	public UtilityPane() {
		super(new Image(ClassLoader.getSystemResource("UtilityPaneDefault.png").toString()));
		this.setFitHeight(300);
		this.setFitWidth(1100);
	}

}
