package gameelement;

import java.util.ArrayList;

import base.UtilPane;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameController;
import logic.GameStage;

public class UtilityPanePlace extends VBox implements UtilPane{

	public UtilityPanePlace() {
		super();
		this.setPrefHeight(300);
		this.setPrefWidth(1100);
		this.setPadding(new Insets(10));

		this.setBackground(UtilPane.background);
		this.setAlignment(Pos.CENTER_LEFT);

		Text guide = new Text(
				"Place : These are stones which are not in play.\n" + "	   Select one to place it in the PlayZone.");
		guide.setFont(new Font("Gill Sans", 35));
		guide.setFill(Color.WHITE);
		UtilityPanePlace.setMargin(guide, new Insets(0, 40, 10, 20));
		this.getChildren().add(guide);

		HBox stoneBox = new StoneBox();
		this.getChildren().add(stoneBox);
	}

	// TODO stones in play must be removed
	
	static class StoneBox extends HBox {
		private static ArrayList<StoneButton> stoneList = new ArrayList<>(StoneButton.getAllStones());

		public void OnClickHandler() {
			for (StoneButton e : stoneList) {
				e.setOnMouseClicked(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent arg0) {
						if (GameStage.isPlacing() == true) {
							GameController.setSelectedstone(e);
							GameController.highlightPlayZonePlaceHolders();
							
							e.setDisable(true);
							
//							System.out.println(stoneList.size());
//							System.out.println("press");
							//System.out.println(GameStage.isPlacing());
							
							/*if(GameController.getSelectedstone() == null) {
								System.out.println("not selected");
							} else 
								System.out.println("selected");*/
						}
					};
				});
			}
		}

	

		public static ArrayList<StoneButton> getStoneList() {
			return stoneList;
		}

		public static void setStoneList(ArrayList<StoneButton> stoneList) {
			StoneBox.stoneList = stoneList;
		}
		public StoneBox() {
			super();
			this.setPrefWidth(1100);
			this.setPadding(new Insets(5));
			this.setAlignment(Pos.CENTER);
			OnClickHandler();
			this.getChildren().addAll(stoneList);

		}

	}

}
