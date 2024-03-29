package logic;

public class GameStage {
	private static boolean placingStage;
	private static boolean hidingStage;
	private static boolean swapingStage;
	private static boolean removingStage;
	private static boolean peekingStage;
	private static boolean challengingStage;
	private static boolean boastingStage;
	private static boolean showdownStage;

	public static void setAllToFalse() {
		placingStage = false;
		hidingStage = false;
		swapingStage = false;
		removingStage = false;
		peekingStage = false;
		challengingStage = false;
		boastingStage = false;
		showdownStage = false;
	}

	public static boolean isShowdownStage() {
		return showdownStage;
	}

	public static void setShowdownStage(boolean showdownStage) {
		GameStage.showdownStage = showdownStage;
	}



	public static boolean isBoastingStage() {
		return boastingStage;
	}

	public static void setBoastingStage(boolean boastingStage) {
		GameStage.boastingStage = boastingStage;
	}

	public static boolean isChallengingStage() {
		return challengingStage;
	}

	public static void setChallengingStage(boolean challengingStage) {
		GameStage.challengingStage = challengingStage;
	}

	public static boolean isPeekingStage() {
		return peekingStage;
	}

	public static void setPeekingStage(boolean peakingStage) {
		GameStage.peekingStage = peakingStage;
	}

	public static boolean isRemovingStage() {
		return removingStage;
	}

	public static void setRemovingStage(boolean removingStage) {
		GameStage.removingStage = removingStage;
	}

	public static boolean isSwapingStage() {
		return swapingStage;
	}

	public static void setSwapingStage(boolean swapingStage) {
		GameStage.swapingStage = swapingStage;
	}

	public static boolean isHidingStage() {
		return hidingStage;
	}

	public static void setHidingStage(boolean hidingStage) {
		GameStage.hidingStage = hidingStage;
	}

	public static boolean isPlacing() {
		return placingStage;
	}

	public static void setPlacing(boolean placing) {
		GameStage.placingStage = placing;
	}
	
	
}
