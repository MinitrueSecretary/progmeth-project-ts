package gameelement;

public class Stone {
	
	private String stoneName;
	private String picURL;
	private boolean isHidden;
	
	
	public Stone(String stoneName) {
		setStoneName(stoneName);
		isHidden = false;
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
			break;
		case "aircraft":
			picURL = "Aircraft.png";
			break;
		case "factory":
			picURL = "Factory.png";
			break;
		case "flask":
			picURL = "Flask.png";
			break;
		case "gear":
			picURL = "Gear.png";
			break;
		case "lightbulb":
			picURL = "Lightbulb.png";
			break;
		case "hardhat":
			picURL = "HardHat.png";
			break;
		case "car":
			picURL = "Car.png";

			break;
		default:
			System.out.println("Such stone type is not in this variation of Tellstones.");
			System.out.println("Stone type automatically set to \"The Chip\".");
			stoneName = "Chip";
			picURL = "Chip.png";

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
		if(isHidden) {
			return "HiddenStone.png";
		}
		return picURL;
	}
	
	public boolean isHidden() {
		return isHidden;
	}


	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}


	
}
