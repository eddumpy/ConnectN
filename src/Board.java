/**
 * 
 * @author Ed Dumpleton
 * @version 1
 * @release 11/01/2018
 */
public class Board {

	private char[][] board;
	private int rows;
	private int columns;

	/**
	 * Board constructor, when a new board is created in the ConnectN class it
	 * allows for the rows and columns to be manipulated if it needs, however the
	 * game should be played with 6 rows and 7 columns
	 * 
	 * @param row
	 * @param col
	 */
	public Board(int row, int col) {
		board = new char[col][row];
		rows = row;
		columns = col;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	/**
	 * Method draws the board to the console when called upon
	 * 
	 * @param player
	 * @param player2
	 * @param player3
	 */
	public void drawBoard(PlayerID player, PlayerID player2, PlayerID player3) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == player.getCounter()) {
					System.out.print("| " + player.getCounter() + " ");
				} else if (board[i][j] == player2.getCounter()) {
					System.out.print("| " + player2.getCounter() + " ");
				} else if (board[i][j] == player3.getCounter()) {
					System.out.print("| " + player3.getCounter() + " ");
				} else {
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		System.out.println("  1   2   3   4   5   6   7");
	}
}
