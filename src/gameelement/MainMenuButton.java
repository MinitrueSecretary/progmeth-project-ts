package gameelement;

import javafx.scene.control.Button;

public class MainMenuButton extends Button {

	public MainMenuButton(String title) {
		super(title);
		this.setPrefSize(250, 70);
		this.setButtonStyle();
	}
	
	public void setButtonStyle() {
		this.setStyle("-fx-background-color: \r\n"
				+ "        #000000,\r\n"
				+ "        linear-gradient(#7ebcea, #2f4b8f),\r\n"
				+ "        linear-gradient(#426ab7, #263e75),\r\n"
				+ "        linear-gradient(#395cab, #223768);\r\n"
				+ "    -fx-background-insets: 0,1,4,7;\r\n"
				+ "    -fx-background-radius: 3,2,2,2;\r\n"
				+ "    -fx-padding: 12 30 12 30;\r\n"
				+ "    -fx-text-fill: white;\r\n"
				+ "	   -fx-font-family: Gill Sans;\r\n"
				+ "    -fx-font-size: 28px;");
	}
}
