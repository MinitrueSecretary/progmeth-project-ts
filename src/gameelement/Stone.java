package gameelement;

public class Stone {
	
	private String stoneName;
	private String picURL;
	private boolean isHidden;
	private boolean isInPlay;
	private int position;
	
	
	public Stone(String stoneName) {
		setStoneName(stoneName);
		isHidden = false;
		isInPlay = false;
	}


	@Override
	public String toString() {
		if(isHidden)
			return "Hidden Stone";
		return "The " + stoneName;
	}


	//Getters and Setters
	public void setStoneName(String stoneName) {
		switch (stoneName) {
		case "Chip":
			picURL = "Chip.png";
			position = 0;
			break;
		case "Aircraft":
			picURL = "Aircraft.png";
			position = 1;
			break;
		case "Factory":
			picURL = "Factory.png";
			position = 2;
			break;
		case "Flask":
			picURL = "Flask.png";
			position = 3;
			break;
		case "Gear":
			picURL = "Gear.png";
			position = 4;
			break;
		case "Lightbulb":
			picURL = "Lightbulb.png";
			position = 5;
			break;
		case "HardHat":
			picURL = "HardHat.png";
			position = 6;
			break;
		case "Car":
			picURL = "Car.png";
			position = 7;
			break;
		default:
			stoneName = "Chip";
			picURL = "Chip.png";
		}
		this.stoneName = stoneName;
	}

	public String getStoneName() {
		return stoneName;
	}


	public boolean isHidden() {
		return isHidden;
	}


	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		if(position > 7 || position < 0) {
			position = 0;
		}
		this.position = position;
	}


	public boolean isInPlay() {
		return isInPlay;
	}


	public void setInPlay(boolean isInPlay) {
		this.isInPlay = isInPlay;
	}
	
}
