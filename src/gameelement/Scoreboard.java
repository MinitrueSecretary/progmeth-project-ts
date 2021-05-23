package gameelement;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameController;
import logic.GameStage;
import logic.TurnManager;
import base.Highlightable;

public class Scoreboard extends VBox implements Highlightable{

	private int playernum;
	private int score;
	private Text scoreText;
	
	private Canvas timerCanvas;
	private Thread timerThread;
	private int time;
	private final int TIMELIMIT;
	private final int SHORT_TIMELIMIT;
	
	private Background background0;
	private Background background1;
	private Background background2;
	
	public Scoreboard(int playernum) {
		super();
		this.setPrefHeight(250);
		this.setPrefWidth(150);
		this.setPadding(new Insets(10));
		Color c1 = playernum > 1 ? Color.DARKRED : Color.BLUEVIOLET;
		this.setBorder(new Border(new BorderStroke(c1, BorderStrokeStyle.SOLID,  CornerRadii.EMPTY, new BorderWidths(5))));
		
		background0 = new Background(new BackgroundFill(Color.WHITE,null,null));
		background1 = new Background(new BackgroundFill(Color.AQUA,null,null));
		background2 = new Background(new BackgroundFill(Color.PINK,null,null));;
		this.setBackground(background0);
		
		this.TIMELIMIT = 20;
		this.SHORT_TIMELIMIT = 5;
		
		score = 0;
		scoreText = new Text();
		scoreText.setFont(new Font("Arial", 80));
		scoreText.setText("" + score);
		
		Color c2 = playernum > 1 ? Color.RED : Color.BLUE;
		Rectangle r = new Rectangle(150, 10, c2);
		
		setPlayernum(playernum);
		setupTimer();

		if(playernum == 1 ) {
			highlight();
		}
		this.getChildren().addAll(scoreText,r,timerCanvas);
		this.setAlignment(Pos.CENTER);
	}

	
	public void setupTimer() {
		timerCanvas = new Canvas(100,50);
		time = TIMELIMIT;
		this.timerThread = getNewThread();
		
	}
	
	public Thread getShowdownThread(){
		return new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				drawCurrentTimeString();

				try {
					while (time > 0) {
						Thread.sleep(1000);
						time--;
						drawCurrentTimeString();
						

					}
					//time out
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							TurnManager.showdownFail();
						}
					});
					
				}
				catch(InterruptedException e) {
					time = TIMELIMIT;
					drawBlankTimeString();
				}
					

				//time out
				
			}
		});
		
	}
	
	public Thread getNewThread() {
		return new Thread(new Runnable() {
			
			@Override
			public void run() {
				drawCurrentTimeString();

				try {
					while (time > 0) {
						Thread.sleep(1000);
						time--;
						drawCurrentTimeString();
					}
					
					time = TIMELIMIT;
					drawBlankTimeString();
					//time out
					if(GameStage.isPlacing() && GameController.getSelectedstone() != null) {
						GameController.getSelectedstone().setDisable(false);
					}
					
					if(GameStage.isSwapingStage() && GameController.isReadyToSwap()) {
						int i = GameController.getStoneIndex1();
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								PlayZone.getStoneInPlay().get(i).setNewStoneImage();
							}
						});
						GameController.setReadyToSwap(false);
					}
					GameStage.setAllToFalse();
					TurnManager.alternateTurns();

					
				}

				catch (InterruptedException e) {
					
					try {
						//Interrupt from peek
						if(GameStage.isPeekingStage()){
							time = SHORT_TIMELIMIT;
							drawCurrentTimeString();
							while (time > 0) {
								Thread.sleep(1000);
								time--;
								drawCurrentTimeString();
							}
							
						//alternate turns is written in another thread
						}
						//Interrupt from Challenge
						else if(GameStage.isChallengingStage()) {
							time = TIMELIMIT;
							drawCurrentTimeStringAsterisk();
							while (time > 0) {
								Thread.sleep(1000);
								time--;
								drawCurrentTimeStringAsterisk();
							}
							//Time Out == Wrong Answer
							TurnManager.answerChallenge(false);
							GameStage.setChallengingStage(false);
							TurnManager.alternateTurns();
						}
						
						//First Boast
						else if(GameStage.isBoastingStage()) {
							System.out.println("Boast");
							time = TIMELIMIT;
							drawCurrentTimeStringAsterisk();
							while (time > 0) {
								Thread.sleep(1000);
								time--;
								drawCurrentTimeStringAsterisk();
							}
							//Time Out == Yield
							TurnManager.yieldToBoast();
							GameStage.setBoastingStage(false);
							TurnManager.alternateTurns();
						}
					
						time = TIMELIMIT;
						drawBlankTimeString();
						
					}
					catch(InterruptedException e2) {
						if(GameStage.isChallengingStage()) {
							time = TIMELIMIT;
							drawBlankTimeString();
						}
						
						else if(GameStage.isBoastingStage()) {
							//Boast Stolen
							if(GameController.isBoastStolen()) {
								time = TIMELIMIT;
								drawCurrentTimeString();
								try {
									while (time > 0) {
										Thread.sleep(1000);
										
										time--;
										drawCurrentTimeString();
									}
									TurnManager.yieldToStolenBoast();		
									time = TIMELIMIT;
									drawBlankTimeString();
									//System.out.println("Boast stolen false");
									GameController.setBoastStolen(false);
									GameStage.setBoastingStage(false);
									TurnManager.alternateTurns();
								}
								//yield or showdown
								catch (InterruptedException e1) {
									time = TIMELIMIT;
									drawBlankTimeString();
								}
								//Time Out == Yield
								
							}
							
							//yield or showdown
							else {
								time = TIMELIMIT;
								drawBlankTimeString();
							}
						}				
						
					}
					
				}

			}
		});
	}
	
	public void startTimer() {
		System.out.println("Turn : Player "+playernum);
		this.timerThread.start();
	}
	
	public void startShortTimer() {
		this.time = SHORT_TIMELIMIT;
		this.timerThread.start();
	}
	
	public void drawCurrentTimeString(){
		GraphicsContext gc = timerCanvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.setFont(new Font(40));
		gc.clearRect(0, 0, this.timerCanvas.getWidth(), this.timerCanvas.getHeight());
		String timeString = String.format("%02d", this.time);
		gc.fillText(timeString, this.timerCanvas.getWidth() / 2 -22, this.timerCanvas.getWidth() / 2 );	
	}
	
	public void drawCurrentTimeStringAsterisk(){
		GraphicsContext gc = timerCanvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.setFont(new Font(40));
		gc.clearRect(0, 0, this.timerCanvas.getWidth(), this.timerCanvas.getHeight());
		String timeString = String.format("%02d", this.time) + "*";
		gc.fillText(timeString, this.timerCanvas.getWidth() / 2 -22, this.timerCanvas.getWidth() / 2 );	
	}
	
	public void drawBlankTimeString(){
		GraphicsContext gc = timerCanvas.getGraphicsContext2D();
		gc.clearRect(0, 0, this.timerCanvas.getWidth(), this.timerCanvas.getHeight());
		
	}
	public int getPlayernum() {
		return playernum;
	}

	public void setPlayernum(int playernum) {
		if(playernum <= 1)
			this.playernum = 1;
		else
			this.playernum = 2;
	}

	public void setScore(int score) {
		this.score = score;
		this.scoreText.setText(""+this.score);
	}
	
	public void addScore() {
		this.score++;
		this.scoreText.setText(""+this.score);
	}

	

	public Thread getTimerThread() {
		return timerThread;
	}


	public void restartTimerThread() {
		this.timerThread = getNewThread();
	}

	public void restartShowdownThread() {
		this.timerThread = getShowdownThread();
	}

	@Override
	public void highlight() {
		if(this.playernum == 1) {
			this.setBackground(background1);
		}
		else {
			this.setBackground(background2);
		}
		
	}


	@Override
	public void unhighlight() {
		this.setBackground(background0);
		
	}
	
	
}
