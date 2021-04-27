package gameelement;

public class Stone {
	
	private String stoneName;
	private boolean isHidden; 
	private int position;
	
	
	public Stone(String stoneName) {
		setStoneName(stoneName);
		isHidden = false;
		position = 0;
	}


	@Override
	public String toString() {
		if(isHidden)
			return "Hidden Stone";
		return "The " + stoneName;
	}


	//Getters and Setters
	public String getStoneName() {
		return stoneName;
	}


	public void setStoneName(String stoneName) {
		switch(stoneName) {
			//name subject to change
			case "Name1" : break;
			case "Name2" : break;
			case "Name3" : break;
			case "Name4" : break;
			case "Name5" : break;
			case "Name6" : break;
			case "Name7" : break;
			case "Name8" : break;
			default: stoneName = "Name8";
		}
		this.stoneName = stoneName;
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
		if(position>8 || position<0) {
			position = 0;
		}
		this.position = position;
	}
	
}
