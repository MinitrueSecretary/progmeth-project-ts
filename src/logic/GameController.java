package logic;

import gameelement.CentralPane;
import gameelement.PlayZone;
import gameelement.StoneButton;
import gameelement.UtilityPane;
import gameelement.UtilityPaneChallenge;
import gameelement.UtilityPanePlace;

public class GameController {
	private static PlayZone playzone;
	private static CentralPane centralPane;
	private static UtilityPane uitilityPane;
	private static UtilityPanePlace uitilityPanePlace;
	private static UtilityPaneChallenge uitilityPaneChallenge;
	private static StoneButton selectedstone;
	private static StoneButton swappingStone;
	private static int stoneIndex;
	private static boolean readyToSwap;
	
	
	
	public static boolean isReadyToSwap() {
		return readyToSwap;
	}
	public static void setReadyToSwap(boolean readyToSwap) {
		GameController.readyToSwap = readyToSwap;
	}
	public static int getStoneIndex() {
		return stoneIndex;
	}
	public static void setStoneIndex(int stoneIndex) {
		GameController.stoneIndex = stoneIndex;
	}
	public static StoneButton getSwappingStone() {
		return swappingStone;
	}
	public static void setSwappingStone(StoneButton swappingStone) {
		GameController.swappingStone = swappingStone;
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
	public static UtilityPane getUitilityPane() {
		return uitilityPane;
	}
	public static void setUitilityPane(UtilityPane uitilityPane) {
		GameController.uitilityPane = uitilityPane;
	}
	public static UtilityPanePlace getUitilityPanePlace() {
		return uitilityPanePlace;
	}
	public static void setUitilityPanePlace(UtilityPanePlace uitilityPanePlace) {
		GameController.uitilityPanePlace = uitilityPanePlace;
	}
	public static UtilityPaneChallenge getUitilityPaneChallenge() {
		return uitilityPaneChallenge;
	}
	public static void setUitilityPaneChallenge(UtilityPaneChallenge uitilityPaneChallenge) {
		GameController.uitilityPaneChallenge = uitilityPaneChallenge;
	}
	
	
	// Minitrue Secretary's part
	
	public static void highlightPlayZonePlaceHolders() {
		playzone.highlightAllPlaceHolders();
	}
	
	public static void unhighlightPlayZonePlaceHolders() {
		playzone.unhighlightAllPlaceHolders();
	}
	
	
}
