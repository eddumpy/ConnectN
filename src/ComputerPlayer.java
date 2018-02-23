import java.util.Random;

/**
 * 
 * @author Ed Dumpleton
 * @version 1
 * @release 11/01/2018
 * @see PlayerID.java
 */
public class ComputerPlayer extends PlayerID {

	private int min = 1;
	private int max = 7;

	public ComputerPlayer(char c) {
		this.counter = c;
	}

	public int getPlayerInput() {

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
