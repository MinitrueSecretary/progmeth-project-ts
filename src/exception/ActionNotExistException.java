package exception;

@SuppressWarnings("serial")
public class ActionNotExistException extends Exception {

	public ActionNotExistException() {
		super("This action does not exist in this variant of Tellstones!!!");
		
	}

}
