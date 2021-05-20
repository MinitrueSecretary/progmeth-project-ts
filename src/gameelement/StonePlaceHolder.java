package gameelement;

import java.util.ArrayList;
import java.util.Collections;

import base.Highlightable;
import base.Selectable;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class StonePlaceHolder extends Button implements Highlightable,Selectable {

	private Stone placingStone;
	private static boolean hidding;
	private static Stone tempStone;

	public static Stone getTempStone() {
		return tempStone;
	}

	public static void setTempStone(Stone targetStone) {
		StonePlaceHolder.tempStone = targetStone;
	}

	public static boolean isHidding() {
		return hidding;
	}

	public static void setHidding(boolean hidding) {
		StonePlaceHolder.hidding = hidding;
	}

	public StonePlaceHolder() {
		super();

		this.setShape(new Rectangle(100, 100));
		this.setStyle("-fx-background-color: Yellow;\r\n -fx-border-color: Black ;\r\n"
				+ "    -fx-border-width: 5 ; \r\n" + "    -fx-border-style: dashed ;");
		// this.setBorder(new Border(new BorderStroke(Color.BLACK,
		// BorderStrokeStyle.DASHED, CornerRadii.EMPTY, new BorderWidths(5))));
//		super.setDisable(true);
		super.setDisable(false);
		this.setVisible(false);
		this.setPrefSize(120, 120);
		this.setPadding(new Insets(10));
		this.setPlacingStone(null);
		this.setHidding(false);
		this.setTempStone(null);
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				try {
					OnclickHandler();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		highlight();
	}

	public Stone getPlacingStone() {
		return placingStone;
	}

	public void setPlacingStone(Stone placingStone) {
		this.placingStone = placingStone;
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		// super.setDisable(false);
		this.setVisible(true);
	}

	@Override
	public void unhighlight() {
		// TODO Auto-generated method stub
		super.setDisable(true);
		this.setVisible(false);
	}

	private void OnclickHandler() throws Exception {
		if (GameController.getSelectedstone() != null && GameStage.isPlacing() == true) {
			this.setPlacingStone(GameController.getSelectedstone().getStone());
			GameController.setSelectedstone(null);
			setNewStone(this.getPlacingStone().getUrl());
			GameStage.setPlacing(false);
			printAllStone();
//			System.out.println(GameController.getSelectedstone());
//			System.out.println(placingStone.getStone().getStoneName());
		} else if (GameStage.isHidingStage() == true) {
			setNewStone("HiddenStone.png");
			// System.out.println(placingStone.getStone().getStoneName());
			this.setHidding(true);
			GameStage.setHidingStage(false);
		} else if (GameStage.isPeakingStage() == true) {
			setNewStone(placingStone.getUrl());
			Thread thread = new Thread(() -> {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					Platform.runLater(new Runnable() {
						@Override
						public void run() {	
							
							
							setNewStone("HiddenStone.png");

						}
					});
					
				
	});
	thread.start();

			
			GameStage.setPeakingStage(false);
		} else if (GameStage.isSwapingStage() == true) {
			if (GameController.isReadyToSwap() == false) {
				GameController.setStoneIndex(PlayZone.getStoneInPlay().indexOf(this));
				GameController.setReadyToSwap(true);
				System.out.println("ready");
			} else if (GameController.isReadyToSwap() == true) {
				Collections.swap(PlayZone.getStoneInPlay(), GameController.getStoneIndex(),
						PlayZone.getStoneInPlay().indexOf(this));
				resetSwapStone(PlayZone.getStoneInPlay(), GameController.getStoneIndex(),
						PlayZone.getStoneInPlay().indexOf(this));
				GameController.setReadyToSwap(false);
//				printAllStone();
				System.out.println("swap");
			}

		}
	}

	public void setNewStone(String url) {
		ImageView img = new ImageView(url);
		img.setFitHeight(100);
		img.setFitWidth(100);
		StonePlaceHolder.this.setShape(new Circle());
		StonePlaceHolder.this.setGraphic(img);
	}

	public void resetSwapStone(ArrayList<StonePlaceHolder> list, int firstIndex, int secondIndex) {
		list.get(firstIndex).setNewStone(list.get(firstIndex).getPlacingStone().getUrl());
		list.get(secondIndex).setNewStone(list.get(secondIndex).getPlacingStone().getUrl());
	}

	public void printAllStone() {
		for (StonePlaceHolder e : PlayZone.getStoneInPlay()) {
			if (e.getPlacingStone() != null) {
				System.out.println(e.getPlacingStone().getStoneName());
			}
		}
	}
}
