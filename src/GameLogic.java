/**
 * 
 * @author Ed Dumpleton
 * @version 1
 * @release 11/01/2018
 */
public class GameLogic extends Counter {

	private int count = 0;
	private int winNum;

	public GameLogic(int win) {
		this.winNum = win;
	}

	/**
	 * Method checks the board to see if there are any winning counters either
	 * horizontally, vertically or diagonally
	 * 
	 * @param board
	 * @param counter
	 * @param d
	 * @return boolean
	 */
	public boolean checkWin(Board board, char counter, int d) {

		char[][] winBoard = board.getBoard();
		boolean hasWon = false;

		// check horizontal
		for (int i = 0; i < winBoard.length; i++) {
			for (int j = 0; j < winBoard[i].length; j++) {
				if (winBoard[i][j] == counter) {
					count++;
					if (count >= winNum) {
						hasWon = true;
					}
				} else {
					count = 0;
				}
			}
			count = 0;
		}

		// check vertical
		for (int i = 0; i < winBoard[0].length; i++) {
			for (int j = 0; j < winBoard.length; j++) {
				if (winBoard[j][i] == counter) {
					count++;
					if (count >= winNum) {
						hasWon = true;
					}
				} else {
					count = 0;
				}
			}
			count = 0;
		}

		// check diagonal '/'
		for (int i = winBoard.length - 1; i > winBoard.length - getDTwo(d); i--) {
			for (int j = 0; j < winBoard[0].length - getDOne(d); j++) {
				if (winBoard[i][j] == counter) {
					count++;
					while (count != 0) {
						if (winBoard[i - count][j + count] == counter) {
							count++;
							if (count >= winNum) {
								hasWon = true;
							}
						} else {
							count = 0;
						}
					}
				}
			}
		}

		// check diagonal '\'
		for (int i = 0; i < winBoard.length - getDOne(d); i++) {
			for (int j = 0; j < winBoard[0].length - getDOne(d); j++) {
				if (winBoard[i][j] == counter) {
					count++;
					while (count != 0) {
						if (winBoard[i + count][j + count] == counter) {
							count++;
							if (count >= winNum) {
								hasWon = true;
							}
						} else {
							count = 0;
						}
					}
				}
			}
		}
		return hasWon;
	}

	/**
	 * Method returns an int so the array range can be changed depending on how many
	 * counters is needed to win in a row
	 * 
	 * @param d
	 * @return int
	 */
	private int getDOne(int d) {

		int n = 0;

		if (d == 3) {
			n = 2;
		} else if (d == 4) {
			n = 3;
		} else if (d == 5) {
			n = 4;
		} else if (d == 6) {
			n = 6;
		}
		return n;
	}

	/**
	 * 2nd method which gives a value, so it can find diagonal win combinations.
	 * 
	 * @param d
	 * @return
	 */
	private int getDTwo(int d) {
		int n = 0;

		if (d == 3) {
			n = 5;
		} else if (d == 4) {
			n = 4;
		} else if (d == 5) {
			n = 3;
		} else if (d == 6) {
			n = 2;
		}
		return n;
	}

	/**
	 * Method checks columns on the board to see if there is space to place a
	 * counter there, if not it returns false and the player has to enter a new
	 * input until it is validated
	 * 
	 * @param input
	 * @param board
	 * @param counters
	 * @param x
	 * @return boolean
	 */
	public boolean validateInput(int input, Board board, char[] counters, int x) {

		char[][] checkBoard = board.getBoard();
		boolean valid = false;

		while (true) {
			try {
				if (checkBoard[0][input - 1] == counters[0]) {
					if (x == 0) {
						System.out.println("Invalid move, that column is full.");
						valid = false;
					} else {
						valid = false;
					}
				}

				else if (checkBoard[0][input - 1] == counters[1]) {
					if (x == 0) {
						System.out.println("Invalid move, that column is full.");
						valid = false;
					} else {
						valid = false;
					}
				}

				else if (checkBoard[0][input - 1] == counters[2]) {
					if (x == 0) {
						System.out.println("Invalid move, that column is full.");
						valid = false;
					} else {
						valid = false;
					}
				}

				else {
					valid = true;
				}

				return valid;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Invalid move, try a different column...");
				return false;
			}
		}

	}

	/**
	 * Method checks to see if the board is full
	 * 
	 * @param board
	 * @param counters
	 * @return boolean
	 */
	public boolean checkDraw(Board board, char[] counters) {

		boolean draw = false;
		int count = 0;
		char[][] drawBoard = board.getBoard();

		for (int i = 0; i < drawBoard[0].length; i++) {
			if (drawBoard[0][i] == counters[0]) {
				count++;
				if (count >= 7) {
					draw = true;
					return draw;
				}
			} else if (drawBoard[0][i] == counters[1]) {
				count++;
				if (count >= 7) {
					draw = true;
					return draw;
				}
			} else if (drawBoard[0][i] == counters[2]) {
				count++;
				if (count >= 7) {
					draw = true;
					return draw;
				}
			} else {
				draw = false;
			}
		}
		return draw;
	}

	/**
	 * getters and setters for winning number
	 * 
	 * @return
	 */
	public int getWinNum() {
		return winNum;
	}

	public void setWinNum(int winNum) {
		this.winNum = winNum;
	}
}
