package exception;

@SuppressWarnings("serial")
public class ButtonNotExistException extends Exception {

	public ButtonNotExistException() {
		super("This action does not exist in this variant of Tellstones!!!");
		
	}

}
