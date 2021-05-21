package logic;

import gameelement.Scoreboard;

public class TurnManager {
	
	private static boolean  isGameEnd;
	private static int player1Score;
	private static int player2Score;
	private static Scoreboard player1;
	private static Scoreboard player2;
	private static boolean isPlayer1Turn;
	
	
	public static void initiate() {
		isGameEnd = false;
		player1Score = 0;
		player2Score = 0;
		
		isPlayer1Turn = true;
		player1.startTimer();
	}
	
	public static void alternateTurns() {
		isPlayer1Turn = !isPlayer1Turn;
		if(isPlayer1Turn) {
			if(!player1.getTimerThread().isAlive()) {
				player1.restartTimerThread();
			}
			player1.highlight();
			player2.unhighlight();
			player1.startTimer();
		}
		else {
			if(!player2.getTimerThread().isAlive()) {
				player2.restartTimerThread();
			}
			player1.unhighlight();
			player2.highlight();
			player2.startTimer();
		}
	}

	
	public static void addScoreToPlayer1() {
		player1Score++;
		player1.setScore(player1Score);
	}
	
	public static void addScoreToPlayer2() {
		player2Score++;
		player2.setScore(player2Score);
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
