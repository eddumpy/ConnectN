/**
 * 
 * @author Ed Dumpleton
 * @version 1
 * @release 11/01/2018
 */
public class Counter {

	/**
	 * Method places the counter on the board The GameLogic class inherits this
	 * method, so no extra objects are needed to be created in the ConnectN class.
	 * 
	 * @param x
	 * @param counters
	 * @param position
	 * @param board
	 */
	
	// default constructor
	public Counter() {
		
	}
	
	public void placeCounter(int x, char[] counters, int position, Board board) {

		char[][] gameBoard = board.getBoard();

		boolean placed = false;
		if (x == 0) {
			for (int i = gameBoard.length - 1; i >= 0; i--) {
				if (!placed) {
					if (gameBoard[i][position - 1] == counters[1]) {
						// skip
					} else if (gameBoard[i][position - 1] == counters[2]) {
						// skip
					} else if (gameBoard[i][position - 1] != counters[0]) {
						gameBoard[i][position - 1] = counters[0];
						placed = true;
					}
				}
			}
		}

		else if (x == 1) {
			for (int i = gameBoard.length - 1; i >= 0; i--) {
				if (!placed) {
					if (gameBoard[i][position - 1] == counters[0]) {
						// skip
					} else if (gameBoard[i][position - 1] == counters[2]) {
						// skip
					} else if (gameBoard[i][position - 1] != counters[1]) {
						gameBoard[i][position - 1] = counters[1];
						placed = true;
					}
				}
			}

		}

		else if (x == 2) {
			for (int i = gameBoard.length - 1; i >= 0; i--) {
				if (!placed) {
					if (gameBoard[i][position - 1] == counters[0]) {
						// skip
					} else if (gameBoard[i][position - 1] == counters[1]) {
						// skip
					} else if (gameBoard[i][position - 1] != counters[2]) {
						gameBoard[i][position - 1] = counters[2];
						placed = true;
					}
				}
			}
		}
	}
}
