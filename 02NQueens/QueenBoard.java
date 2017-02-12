public class QueenBoard {
    
    private int[][] board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }
    
    public boolean solve() {
	if (solveH(0)) return true;
	for (int i = 0; i < board.length; i += 1) removeQueen(i);
	return false;
    }

    private boolean solveH(int row) {
	if (board.length <= 3) return false;
	if (row >= board.length) return true;
	for (int col = 0; col < board.length; col += 1) {
	    //System.out.println(row + " " + col);	  
	    System.out.print("\033[H\033[2J\n");
	    System.out.flush();
	    System.out.println(this);
	    if (board[row][col] == 0) {
		addQueen(row, col);
		if (solveH(row + 1)) return true;
		else removeQueen(row);
	    }
	}
	removeQueen(row - 1);
	return false;
    }

    public int getSolutionCount() {
	for (int i = 0; i < board.length; i += 1) {
	    //System.out.println(i);
	    if (solveH(i)) solutionCount += 1;
	    for (int j = 0; j < board.length; j += 1) removeQueen(j);
	    board[i][0] = 1;
	}
    	return (solutionCount > 0) ? solutionCount : -1;
    }

    private void addQueen(int row, int col) {
	for (int i = 0; i < board.length; i += 1) {
	    board[row][i] += 1;
	    board[i][col] += 1;
	}
	int r = row;
	int c = col;
	while (r >= 0 && c >= 0) board[r--][c--] += 1;
	r = row;
	c = col;
	while (r >= 0 && c < board.length) board[r--][c++] += 1;
	r = row;
	c = col;
	while (r < board.length && c < board.length) board[r++][c++] += 1;
	r = row;
	c = col;
	while (r < board.length && c >= 0) board[r++][c--] += 1;
	board[row][col] = -1;
    }

    private void removeQueen(int row, int col) {
	for (int i = 0; i < board.length; i += 1) {
	    board[row][i] -= 1;
	    board[i][col] -= 1;
	}
	int r = row;
	int c = col;
	while (r > 0 && c > 0) board[r--][c--] -= 1;
	r = row;
	c = col;
	while (r < board.length && c < board.length) board[r++][c++] -= 1;
	board[row][col] = 0;
    }

    private void removeQueen(int row) {
	for (int col = 0; col < board.length; col += 1) {
	    if (board[row][col] < 0) {
	        for (int i = 0; i < board.length; i += 1) {
		    board[row][i] -= 1;
		    board[i][col] -= 1;
		}
		int r = row;
		int c = col;
		while (r >= 0 && c >= 0) board[r--][c--] -= 1;
		r = row;
		c = col;
		while (r >= 0 && c < board.length) board[r--][c++] -= 1;
		r = row;
		c = col;
		while (r < board.length && c < board.length) board[r++][c++] -= 1;
		r = row;
		c = col;
		while (r < board.length && c >= 0) board[r++][c--] -= 1;
		board[row][col] = 0;
	    }
	}
    }
	
    public String toString() {
	String boardString = "";
	for (int row = 0; row < board.length; row += 1) {
	    for (int col = 0; col < board.length; col += 1) {	      
		if (board[row][col] < 0) boardString += "Q ";
		if (board[row][col] >= 0) boardString += "_ ";
	    }
	    boardString += "\n";
	}	
	return boardString;
    }

    public String toStringDebug() {
	String boardString = "";
	for (int row = 0; row < board.length; row += 1) {
	    for (int col = 0; col < board.length; col += 1) boardString += board[row][col] + " ";
	    boardString += "\n";
	}	
	return boardString;
    }

    /*
    public static void main(String[] args) {
	QueenBoard a = new QueenBoard(9);
        a.addQueen(2, 2);
	a.removeQueen(2);
	//System.out.println(a.solve());
	//System.out.println(a.toString());
	System.out.println(a.getSolutionCount());
    }
    */
    
}
