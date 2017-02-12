public class QueenBoard {
    
    private int[][] board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve() {
	return solveH(0);
    }

    private boolean solveH(int row) {
	if (row >= board.length) return true;
	for (int col = 0; col < board.length; col += 1) {
	    if (board[row][col] == 0) {
		addQueen(row, col);
		return true && solveH(row + 1);
	    }
	    else removeQueen(row, col);
	}
	return false;
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount() {
    	return -1;
    }

    private void addQueen(int row, int col) {
	board[row][col] = -4;
	for (int i = 0; i < board.length; i += 1) {
	    board[row][i] += 1;
	    board[i][col] += 1;
	}
	int r = row;
	int c = col;
	while (r > 0 && c > 0) board[r - 1][c - 1] += 1;
	r = row;
	c = col;
	while (r < board.length && c < board.length) board[r + 1][c + 1] += 1;
    }

    private void removeQueen(int row, int col) {
	board[row][col] = -4;
	for (int i = 0; i < board.length; i += 1) {
	    board[row][i] -= 1;
	    board[i][col] -= 1;
	}
	int r = row;
	int c = col;
	while (r > 0 && c > 0) board[ r - 1][c-1] -= 1;
	r = row;
	c = col;
	while (r < board.length && c < board.length) board[r + 1][c + 1] -= 1;
    }
	
    
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString() {
	String boardString = "";
	for (int row = 0; row < board.length; row += 1) {
	    for (int col = 0; col < board.length; col += 1) {
		boardString += board[row][col] + " ";
		/*
		if (board[row][col] < 0) boardString += "Q ";
		if (board[row][col] == 0) boardString += "_ ";
		if (board[row][col] > 0) boardString += board[row][col] + " ";
		*/
	    }
	    boardString += "\n";
	}	
	return boardString;
    }
    
    public static void main(String[] args) {
	QueenBoard a = new QueenBoard(5);
	System.out.println(a);
	System.out.println(a.solve());
	System.out.println(a);
    }
    
}
