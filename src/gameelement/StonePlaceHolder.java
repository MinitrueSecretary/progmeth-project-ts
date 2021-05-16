package gameelement;

import base.Highlightable;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class StonePlaceHolder extends Button implements Highlightable {

	public StonePlaceHolder() {
		super();
		this.setShape(new Rectangle(100, 100));
		this.setStyle("-fx-background-color: Yellow;\r\n -fx-border-color: Black ;\r\n"
				+ "    -fx-border-width: 5 ; \r\n"
				+ "    -fx-border-style: dashed ;");
		//this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, new BorderWidths(5))));
		super.setDisable(true);
		this.setVisible(false);
		this.setPrefSize(100, 100);
		//highlight();
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		//super.setDisable(false);
		this.setVisible(true);
	}

	@Override
	public void unhighlight() {
		// TODO Auto-generated method stub
		super.setDisable(true);
		this.setVisible(false);
	}

}
