package base;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public abstract class ControlButton extends Button implements Highlightable{

	
	private Border border;
	private Border transparentBorder;
	
	public ControlButton() {
		super();
		this.setPrefSize(160, 70);
		this.setButtonStyle();
		
		this.setHover();
		this.border = new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(5)));
		this.transparentBorder = new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(5)));
		this.unhighlight();
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
				+ "	   -fx-font-family: Gill Sans;\r\n"
				+ "    -fx-font-size: 28px;");
	}
	
	//"Challenge" is too long for 28px size Text
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
				+ "	   -fx-font-family: Gill Sans;\r\n"
				+ "    -fx-font-size: 20px;");
	}
	
	public void setPrefSize(double i, double j) {
		super.setPrefSize(i, j);
	}
	
	public void setHover() {
		this.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				highlight();
				
			}
		});
		
		this.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				unhighlight();
			}
	
		});
	}
	@Override
	public void highlight() {
		this.setBorder(border);
		
	}
	@Override
	public void unhighlight() {
		this.setBorder(transparentBorder);
		
	}
	
}
