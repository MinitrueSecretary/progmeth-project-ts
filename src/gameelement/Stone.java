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
		switch (stoneName.toLowerCase().trim()) {
		case "chip":
			picURL = "Chip.png";
			position = 0;
			break;
		case "aircraft":
			picURL = "Aircraft.png";
			position = 1;
			break;
		case "factory":
			picURL = "Factory.png";
			position = 2;
			break;
		case "flask":
			picURL = "Flask.png";
			position = 3;
			break;
		case "gear":
			picURL = "Gear.png";
			position = 4;
			break;
		case "lightbulb":
			picURL = "Lightbulb.png";
			position = 5;
			break;
		case "hardhat":
			picURL = "HardHat.png";
			position = 6;
			break;
		case "car":
			picURL = "Car.png";
			position = 7;
			break;
		default:
			System.out.println("Such stone type is not in this variation of Tellstones.");
			System.out.println("Stone type automatically set to \"The Chip\".");
			stoneName = "Chip";
			picURL = "Chip.png";
			position = 0;
		}
		this.stoneName = stoneName;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stoneName == null) ? 0 : stoneName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stone other = (Stone) obj;
		if (stoneName == null) {
			if (other.stoneName != null)
				return false;
		} else if (!stoneName.equals(other.stoneName))
			return false;
		return true;
	}


	public String getStoneName() {
		return stoneName;
	}

	public String getUrl() {
		return picURL;
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
