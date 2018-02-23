/**
 * Abstract class has been created so human and computer player can inherit
 * these classes, and allows us to use polymorphism in the ConnectN class.
 * 
 * @author Ed Dumpleton
 * @version 1
 * @release 11/01/2018
 */
public abstract class PlayerID {

	public char counter;

	/**
	 * Get player inputs
	 * 
	 */
	public abstract int getPlayerInput();

	/**
	 * Both human and computer player will need getters and setters for their
	 * counter, so their bodies are filled in, in the abstract class.
	 * 
	 * @return
	 */
	public char getCounter() {
		return counter;
	}

	public void setCounter(char counter) {
		this.counter = counter;
	}

}