package base;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

public interface UtilPane {
	Image image = new Image(ClassLoader.getSystemResource("UtilityPaneBlank.png").toString());
	Background background = new Background(new BackgroundImage(image, null, null, null, null));
}
