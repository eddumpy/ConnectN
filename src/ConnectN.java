import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 * @author Ed Dumpleton
 * @version 1
 * @release 11/01/2018
 */
public class ConnectN {

	private int players;
	private boolean finish = false;
	private Scanner reader;
	private int n;

	/**
	 * Constructor could be used to add more players to the game.
	 * 
	 * @param players
	 */
	public ConnectN(int players) {

		this.players = players;
	}

	/**
	 * The play game method
	 * 
	 */
	public void playGame() {

		// Intro message
		System.out.println("Welcome to Connect N!");
		System.out.println("There are 3 players red, yellow and green");
		System.out.println("You are the red counter and the computer is the yellow and green counters");
		System.out.println("To play the game, type in the number of the column you want to drop your counter in");
		System.out.println("A player wins by connecting N counters in a row - vertically, horizontally or diagonally");
		System.out.println("You get to choose the value of N, where N has to be 2 < N < 7.");

		// Creates new game with however many moves you wish to finish with
		n = GetN();
		GameLogic game = new GameLogic(n);

		// Creates a new board with 7 columns and 6 rows
		Board board = new Board(7, 6);

		/*
		 * Creates the players and stores them in a polymorphic array One human player
		 * and two computer players if you want to add another player, pass the number
		 * of players through the ConnectN constructor and add either
		 */
		PlayerID player[] = new PlayerID[players];
		player[0] = new HumanPlayer('r');
		player[1] = new ComputerPlayer('y');
		player[2] = new ComputerPlayer('g');

		// stores the players counters in an array
		char[] counters = { player[0].getCounter(), player[1].getCounter(), player[2].getCounter() };

		// playing game algorithm
		while (!finish) {

			// iterates through each players turn
			for (int x = 0; x < players; x++) {

				boolean turn = false;
				char counter = player[x].getCounter();

				// Human Player algorithm
				if (x == 0) {
					board.drawBoard(player[0], player[1], player[2]);
					while (!turn) {
						int input = player[x].getPlayerInput();
						if (game.validateInput(input, board, counters, x) == true) {
							game.placeCounter(x, counters, input, board);
							turn = true;
						} else {
							turn = false;
						}
					}
				}
				// AI Algorithm
				else {
					while (!turn) {
						int input = player[x].getPlayerInput();
						if (game.validateInput(input, board, counters, x) == true) {
							System.out.println("Computer '" + player[x].getCounter() + "': " + input);
							game.placeCounter(x, counters, input, board);
							turn = true;
						} else {
							turn = false;
						}
					}
				}
				// checks to see if there is a draw/win after each turn
				if (game.checkDraw(board, counters) == true) {
					board.drawBoard(player[0], player[1], player[2]);
					System.out.println("Game is a draw.");
					finish = true;
				} else if (game.checkWin(board, counter, n) == true) {
					board.drawBoard(player[0], player[1], player[2]);
					if (x == 0) {
						System.out.println("Congratulations, you have won the game!");
						finish = true;
						x = players; // this forces the iteration to end
					} else {
						System.out.println(
								"Computer '" + player[x].getCounter() + "' has won the game, better luck next time.");
						finish = true;
						x = players; // this forces the iteration to end
					}
				}
			}
		}
		// asks player if they want to reset game or exit
		resetGame();
	}

	/**
	 * Method to provide player with an option to reset the game.
	 */
	public void resetGame() {

		System.out.println("To reset game input 'r' and press enter,");
		System.out.println("to exit game input any other key and press enter: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			String r = reader.readLine();
			if (r.charAt(0) == 'r') {
				ConnectN resetConnectN = new ConnectN(3);
				resetConnectN.playGame();
			} else {
				System.exit(0);
			}

		} catch (IOException e) {
			System.exit(0);
		} catch (StringIndexOutOfBoundsException s) {
			System.exit(0);
		}

	}

	/**
	 * Method returns user input, after they choose what N is
	 * 
	 * @return
	 */
	public int GetN() {

		int loop = 0;
		System.out.println("Enter N: ");

		while (loop == 0) {
			try {
				reader = new Scanner(System.in);
				n = reader.nextInt();
				if (n < 3 | n > 6) {
					System.out.println("Enter number between 3-6: ");
				} else {
					loop++;
				}
			} catch (Exception e) {
				System.out.println("Enter number between 3-6: ");
			}
		}
		return n;
	}

	/**
	 * Getters and setters for number of players
	 * 
	 * @return
	 */
	public int getPlayers() {

		return players;
	}

	public void setPlayers(int players) {
		this.players = players;
	}

	public static void main(String[] args) {

		// Creates new game of ConnectN with 3 players
		ConnectN connectN = new ConnectN(3);
		connectN.playGame();
	}

}
