package base;

import javafx.scene.control.Button;

public abstract class ControlButton extends Button {

	
	
	
	public ControlButton() {
		super();
		this.setPrefSize(150, 70);
		this.setButtonStyle();
	}

	//can be  moved to another class in the future
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
				+ "    -fx-font-weight: bold;"
				+ "    -fx-font-size: 30px;");
	}
	
	//"Challenge" is too long for 30px size Text
	public void setChallengeButtonStyle() {
		this.setStyle("-fx-background-color: \r\n"
				+ "        #000000,\r\n"
				+ "        linear-gradient(#7ebcea, #2f4b8f),\r\n"
				+ "        linear-gradient(#426ab7, #263e75),\r\n"
				+ "        linear-gradient(#395cab, #223768);\r\n"
				+ "    -fx-background-insets: 0,1,4,7;\r\n"
				+ "    -fx-background-radius: 3,2,2,2;\r\n"
				+ "    -fx-padding: 12 30 12 30;\r\n"
				+ "    -fx-text-fill: white;\r\n"
				+ "    -fx-font-weight: bold;"
				+ "    -fx-font-size: 18px;");
	}
	
	
}
