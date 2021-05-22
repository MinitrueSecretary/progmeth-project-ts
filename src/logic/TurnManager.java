package logic;

import gameelement.Scoreboard;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import roots.MainGameRoot;

public class TurnManager {
	
	private static boolean  isGameEnd;
	
	private static int player1Score;
	private static int player2Score;
	private static Scoreboard player1;
	private static Scoreboard player2;
	
	private static boolean isUpgraded1;
	private static boolean isUpgraded2;
	
	private static boolean isPlayer1Turn;
	
	private static MainGameRoot gameRoot;
	
	
	public static void initiate(MainGameRoot gameRoot) {
		isGameEnd = false;
		player1Score = 0;
		player2Score = 0;
		
		isUpgraded1 = false;
		isUpgraded2 = false;
		
		TurnManager.gameRoot = gameRoot;
		
		isPlayer1Turn = true;
		player1.startTimer();
	}
	
	public static void interruptClock() {
		if(isPlayer1Turn) {
			player1.getTimerThread().interrupt();
		}
		else {
			player2.getTimerThread().interrupt();
		}
	}
	
	public static void alternateTurns() {
		
		//enable the Buttons again
		gameRoot.enableCPButtons();
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gameRoot.setUtilPane();	
			}
		});
		
		isPlayer1Turn = !isPlayer1Turn;
		if(isPlayer1Turn) {
			player2.getTimerThread().interrupt();
			
			if(!player1.getTimerThread().isAlive()) {
				player1.restartTimerThread();
			}
			
			player2.unhighlight();
			
			player1.highlight();
			player1.startTimer();
		}
		else {
			player1.getTimerThread().interrupt();
			
			if(!player2.getTimerThread().isAlive()) {
				player2.restartTimerThread();
			}
			player1.unhighlight();
			
			player2.highlight();
			player2.startTimer();
		}
	}
	
	public static void continueTurn() {
		if(isPlayer1Turn) {
			player1.restartTimerThread();
			player1.startTimer();
		}
		else {
			player2.restartTimerThread();
			player2.startTimer();
		}
	}
	
	public static Scoreboard getCurrentPlayerScoreboard() {
		if(isPlayer1Turn) {
			return player1;
		}
		return player2;
	}
	
	public static Scoreboard getShowdownPlayer() {
		if(isPlayer1Turn == GameController.isBoastStolen()) {
			return player2;
		}
		return player1;
	}
	
	public static void answerChallenge(boolean isCorrect) {

		if(isCorrect != isPlayer1Turn) {
			addScoreToPlayer1();
		}
		else {
			addScoreToPlayer2();
		}
	}
	
   public static void yieldToBoast() {
	   if(isPlayer1Turn) {
		   addScoreToPlayer1();
	   }
	   else {
		   addScoreToPlayer2();
	   }
   }
   
   public static void yieldToStolenBoast() {
	   if(isPlayer1Turn) {
		   addScoreToPlayer2();
	   }
	   else {
		   addScoreToPlayer1();
	   }
   }
	
	public static void addScoreToPlayer1() {
		player1Score++;
		player1.setScore(player1Score);
		isUpgraded2 = true;
	}
	
	public static void addScoreToPlayer2() {
		player2Score++;
		player2.setScore(player2Score);
		isUpgraded1 = true;
	}
	
	
	//getters and setters
	public static boolean isGameEnd() {
		return isGameEnd;
	}

	public static void setGameEnd(boolean isGameEnd) {
		TurnManager.isGameEnd = isGameEnd;
	}

	public static int getPlayer1Score() {
		return player1Score;
	}


	public static int getPlayer2Score() {
		return player2Score;
	}


	public static Scoreboard getPlayer1() {
		return player1;
	}

	public static void setPlayer1(Scoreboard player1) {
		TurnManager.player1 = player1;
	}

	public static Scoreboard getPlayer2() {
		return player2;
	}

	public static void setPlayer2(Scoreboard player2) {
		TurnManager.player2 = player2;
	}

	public static boolean isPlayer1Turn() {
		return isPlayer1Turn;
	}


	
	
}
