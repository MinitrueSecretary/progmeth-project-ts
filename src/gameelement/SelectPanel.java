package gameelement;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class SelectPanel extends GridPane {
	
	public SelectPanel() {
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25, 25, 25, 25));
		for(int i =0; i<8;i++) {
			StoneButton s = StoneButton.getAllStones().get(i);
			this.add(s, i, 0);
			Text t = new Text(s.getStone().toString());
			this.add(t, i, 1);
			SelectPanel.setHalignment(s,HPos.CENTER);
			SelectPanel.setHalignment(t,HPos.CENTER);
			
		}
		
	}
}
