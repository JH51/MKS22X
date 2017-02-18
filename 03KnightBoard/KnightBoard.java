public class KnightBoard {
    
    private int[][] board;
    
    private int[] dRow = {-2, -2, -1, -1, 1, 1, 2, 2};
    private int[] dCol = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingCols][startingRows];
    }
    
    public String toString() {
	String boardString = "";
	for (int row = 0; row < board.length; row += 1) {
	    for (int col = 0; col < board[row].length; col += 1) {	      
		if (board[row][col] < 10) boardString += " ";
		boardString += board[row][col] + " ";
	    }
	    boardString += "\n";
	}
	return boardString;
    }
    
    public void solve() {
	System.out.println(solveH(0, 0, 1));
    }
    
    private boolean solveH(int row, int col, int level) {
	boolean solved = false;
	System.out.println(level + " " + board.length * board[row].length + "\n" + row + " " + col + "\n" + this);
	if (level > board.length * board[row].length) return true;
	try {
	    if (board[row][col] == 0) board[row][col] = level;
	    else return false;
	    for (int i = 0; i < 8; i += 1) {
		if (solveH(row + dRow[i], col + dCol[i], level + 1)) solved = true;
	    }
	    if (solved) return solved;
	    for (int r = 0; r < board.length; r += 1) {
		for (int c = 0; c < board[row].length; c += 1) {
		    if (board[r][c] >= level) board[r][c] = 0;
		}
	    }
	}
	catch (IndexOutOfBoundsException e) { return false; }
	return false;
    }

    public static void main(String[] args) {
	KnightBoard a = new KnightBoard(7,7);
	//System.out.println(a.solveH(3,3,1));
	a.solve();
	System.out.println(a);
    }
    
}
