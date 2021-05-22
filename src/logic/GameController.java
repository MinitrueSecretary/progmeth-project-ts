package logic;

import gameelement.CentralPane;
import gameelement.PlayZone;
import gameelement.Stone;
import gameelement.StoneButton;
import gameelement.StonePlaceHolder;
import gameelement.UtilityPane;
import gameelement.UtilityPaneChallenge;
import gameelement.UtilityPanePlace;

public class GameController {
	private static PlayZone playzone;
	private static CentralPane centralPane;
	private static UtilityPane utilityPane;
	private static UtilityPanePlace utilityPanePlace;
	private static UtilityPaneChallenge utilityPaneChallenge;
	private static StoneButton selectedstone;
	private static StoneButton swappingStone1;
	private static StoneButton swappingStone2;
	private static int stoneIndex1;
	private static int stoneIndex2;
	private static StoneButton guessStone;
	
	private static boolean readyToSwap;
	private static boolean OnShowdown;
	
	
	public static boolean isOnShowdown() {
		return OnShowdown;
	}

	public static void setOnShowdown(boolean onShowdown) {
		OnShowdown = onShowdown;
	}

	public static StoneButton getGuessStone() {
		return guessStone;
	}

	public static void setGuessStone(StoneButton guessStone) {
		GameController.guessStone = guessStone;
	}
	

	
	public static StoneButton getSelectedstone() {
		return selectedstone;
	}
	

	public static void setSelectedstone(StoneButton selectedstone) {
		GameController.selectedstone = selectedstone;
	}
	public static PlayZone getPlayzone() {
		return playzone;
	}
	public static void setPlayzone(PlayZone playzone) {
		GameController.playzone = playzone;
	}
	public static CentralPane getCentralPane() {
		return centralPane;
	}
	public static void setCentralPane(CentralPane centralPane) {
		GameController.centralPane = centralPane;
	}
	
	
	public static UtilityPane getUtilityPane() {
		return utilityPane;
	}

	public static void setUtilityPane(UtilityPane utilityPane) {
		GameController.utilityPane = utilityPane;
	}

	public static UtilityPanePlace getUtilityPanePlace() {
		return utilityPanePlace;
	}

	public static void setUtilityPanePlace(UtilityPanePlace utilityPanePlace) {
		GameController.utilityPanePlace = utilityPanePlace;
	}

	public static UtilityPaneChallenge getUtilityPaneChallenge() {
		return utilityPaneChallenge;
	}

	public static void setUtilityPaneChallenge(UtilityPaneChallenge utilityPaneChallenge) {
		GameController.utilityPaneChallenge = utilityPaneChallenge;
	}
	// Minitrue Secretary's part
	
	public static void highlightPlayZonePlaceHolders() {
		playzone.highlightAllPlaceHolders();
	}
	
	public static void unhighlightPlayZonePlaceHolders() {
		playzone.unhighlightAllPlaceHolders();
	}

	
	
	public static boolean isReadyToSwap() {
		return readyToSwap;
	}
	public static void setReadyToSwap(boolean readyToSwap) {
		GameController.readyToSwap = readyToSwap;
	}


	public static int getStoneIndex1() {
		return stoneIndex1;
	}

	public static void setStoneIndex1(int stoneIndex1) {
		GameController.stoneIndex1 = stoneIndex1;
	}

	public static int getStoneIndex2() {
		return stoneIndex2;
	}

	public static void setStoneIndex2(int stoneIndex2) {
		GameController.stoneIndex2 = stoneIndex2;
	}
	
	public static void swapStones() {
		StonePlaceHolder placeHolder1 = PlayZone.getStoneInPlay().get(stoneIndex1);
		StonePlaceHolder placeHolder2 = PlayZone.getStoneInPlay().get(stoneIndex2);
		
		Stone stone1 = placeHolder1.getPlacingStone();
		Stone stone2 = placeHolder2.getPlacingStone();
		
		placeHolder1.setNewStoneImage(stone2.getUrl());
		placeHolder1.setPlacingStone(stone2);
		
		placeHolder2.setNewStoneImage(stone1.getUrl());
		placeHolder2.setPlacingStone(stone1);
	}
	
	public static void disableUtilityPaneChallenge(StoneButton excluded) {
		utilityPaneChallenge.disableAllButOne(excluded);
	}

	public static void enableUtilityPaneChallenge() {
		utilityPaneChallenge.enableAllButtons();
	}
}
