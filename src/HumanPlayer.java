import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Ed Dumpleton
 * @version 1
 * @release 11/01/2018
 * @see PlayerID.java
 */
public class HumanPlayer extends PlayerID {

	private BufferedReader input;

	public HumanPlayer(char c) {
		this.counter = c;
	}

	public int getPlayerInput() {

		while (true) {
			try {
				System.out.print("Enter Move: ");
				input = new BufferedReader(new InputStreamReader(System.in));
				String userInput = input.readLine();
				int move = Integer.parseInt(userInput);
				return move;
			} catch (NumberFormatException e) {
				System.out.println("Enter number between 1-7 to play Connect Four. Try again...");
			} catch (IOException e) {
				System.out.println("Invalid Move...");
			}
		}
	}
}
