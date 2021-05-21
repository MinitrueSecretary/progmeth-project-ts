package logic;

public class GameStage {
	private static boolean placingStage;
	private static boolean hidingStage;
	private static boolean swapingStage;
	private static boolean removingStage;
	private static boolean peakingStage;
	private static boolean challengingStage;
	private static boolean BoastingStage;
	private static boolean PausingStage;

	public static boolean isPausingStage() {
		return PausingStage;
	}

	public static void setPausingStage(boolean pausingStage) {
		PausingStage = pausingStage;
	}

	public static boolean isBoastingStage() {
		return BoastingStage;
	}

	public static void setBoastingStage(boolean boastingStage) {
		BoastingStage = boastingStage;
	}

	public static boolean isChallengingStage() {
		return challengingStage;
	}

	public static void setChallengingStage(boolean challengingStage) {
		GameStage.challengingStage = challengingStage;
	}

	public static boolean isPeakingStage() {
		return peakingStage;
	}

	public static void setPeakingStage(boolean peakingStage) {
		GameStage.peakingStage = peakingStage;
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
