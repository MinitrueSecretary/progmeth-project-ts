package gameelement;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.media.AudioClip;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import logic.GameController;
import logic.GameStage;
import logic.TurnManager;

public class StonePlaceHolder extends Button {

	private Stone placingStone;
	private boolean isHidden;
	private static AudioClip stoneSFX;
	private static AudioClip correctSFX;
	private static AudioClip wrongSFX;




	public StonePlaceHolder() {
		super();
		stoneSFX = new AudioClip(ClassLoader.getSystemResource("sound/StoneSFX.mp3").toString());
		stoneSFX.setVolume(0.3);
		
		correctSFX = new AudioClip(ClassLoader.getSystemResource("sound/CorrectSFX.mp3").toString());
		correctSFX.setVolume(0.5);
		wrongSFX = new AudioClip(ClassLoader.getSystemResource("sound/WrongSFX.mp3").toString());
		wrongSFX.setVolume(0.2);
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
		this.setHidden(false);
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				OnclickHandler();
			}
		});

	}


	
	private void OnclickHandler() {
		
		//place
		if (GameController.getSelectedstone() != null && GameStage.isPlacing() && this.getPlacingStone() == null) {
			this.setPlacingStone(GameController.getSelectedstone().getStone());
			GameController.setSelectedstone(null);
			setNewStoneImage(this.getPlacingStone().getUrl());
			GameStage.setPlacing(false);
			GameController.unhighlightPlayZonePlaceHolders();
			stoneSFX.play();
			TurnManager.alternateTurns();
			//printAllStone();
//			System.out.println(GameController.getSelectedstone());
//			System.out.println(placingStone.getStone().getStoneName());
			
		
		//hide	
		} else if (GameStage.isHidingStage()) {
			setNewStoneImage("HiddenStone.png");
			// System.out.println(placingStone.getStone().getStoneName());
			stoneSFX.play();
			this.setHidden(true);
			GameStage.setHidingStage(false);
			TurnManager.alternateTurns();
			
		//peek
		} else if (GameStage.isPeekingStage()) {
			this.setHidden(false);
			setNewStoneImage(placingStone.getUrl());
			//System.out.println("Peeking");
			TurnManager.interruptClock();
			GameController.getCentralPane().getButtonpanel().getCancelButton().setDisable(true);
			Thread thread = new Thread(() -> {
				try {
					TurnManager.getCurrentPlayerScoreboard().getTimerThread().join();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				Platform.runLater(new Runnable() {
					@Override
					public void run() {

						setNewStoneImage("HiddenStone.png");

					}
				});
				this.setHidden(true);
				TurnManager.alternateTurns();
				GameStage.setPeekingStage(false);
			});
			thread.start();


			
			//swap
		} else if (GameStage.isSwapingStage()) {
			// need to edit this
			if (!GameController.isReadyToSwap()) {
				GameController.setStoneIndex1(PlayZone.getStoneInPlay().indexOf(this));
				GameController.setReadyToSwap(true);
				GameController.getCentralPane().getButtonpanel().getCancelButton().setDisable(true);
				System.out.println("Swap 1 Selected");
				this.enlarge();
			} else if(GameController.getStoneIndex1() != PlayZone.getStoneInPlay().indexOf(this)){
				stoneSFX.play();
				GameController.setStoneIndex2(PlayZone.getStoneInPlay().indexOf(this));
				GameController.swapStones();
				//printAllStone();
				System.out.println("swap");
				GameStage.setSwapingStage(false);
				GameController.setReadyToSwap(false);
				TurnManager.alternateTurns();
			}
				

		}
		//challenge
		else if (GameStage.isChallengingStage()) {
			if (GameController.getGuessStone() != null && this.getPlacingStone() != null) {
				this.setHidden(false);
				this.setNewStoneImage();
				
				boolean isCorrect = GameController.getGuessStone().getStone().equals(placingStone);
				TurnManager.answerChallenge(isCorrect);
				System.out.println(isCorrect?"Correct!":"Incorrect!");
				if(isCorrect) {
					correctSFX.play();
				}
				else {
					wrongSFX.play();
				}
				TurnManager.getCurrentPlayerScoreboard().drawBlankTimeString();
				
				GameController.setGuessStone(null);
				GameController.enableUtilityPaneChallenge();
				GameStage.setChallengingStage(false);
				TurnManager.alternateTurns();
			}
		} 
		
		//showdown
		else if(GameStage.isShowdownStage()) {
			if (GameController.getGuessStone() != null && this.getPlacingStone() != null) {
				this.setHidden(false);
				this.setNewStoneImage();
				boolean isCorrect = GameController.getGuessStone().getStone().equals(placingStone);
				System.out.println(isCorrect?"Correct!":"Incorrect!");
				TurnManager.getCurrentPlayerScoreboard().drawBlankTimeString();
				GameController.getUtilityPaneShowdown().disableNotHiddens();
				TurnManager.interruptClock();
				
				if(!isCorrect) {
					wrongSFX.play();
					TurnManager.showdownFail();
				}
				else if(GameController.getHiddenStones().size() == 0) {
					TurnManager.showdownComplete();
				}
				else {
					correctSFX.play();
					TurnManager.continueShowdown();
				}
			}
		}
		

	}

	public void setNewStoneImage() {
		String url = this.getPlacingStone().getUrl();
		setNewStoneImage(url);
	}
	
	public void setNewStoneImage(String url) {
		ImageView img = new ImageView(url);
		img.setFitHeight(100);
		img.setFitWidth(100);
		this.setPadding(new Insets(10));
		this.setShape(new Circle());
		this.setGraphic(img);
	}
	
	public void enlarge() {
		String url = this.getPlacingStone().getUrl();
		ImageView img = new ImageView(url);
		img.setFitHeight(120);
		img.setFitWidth(120);
		this.setPadding(Insets.EMPTY);
		this.setShape(new Circle());
		this.setGraphic(img);
	}


	public void printAllStone() {
		for (StonePlaceHolder e : PlayZone.getStoneInPlay()) {
			if (e.getPlacingStone() != null) {
				System.out.println(e.getPlacingStone().getStoneName());
			}
		}
	}
	
	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean hidden) {
		this.isHidden = hidden;
		if(this.getPlacingStone() != null) {
			this.getPlacingStone().setHidden(hidden);
		}
	
	}
	public Stone getPlacingStone() {
		return placingStone;
	}

	public void setPlacingStone(Stone placingStone) {
		this.placingStone = placingStone;
	}

}
