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
        try {
	    if (board[row][col] == 0) board[row][col] = level;	    
	    else return false;
	}
	catch (IndexOutOfBoundsException e) { return false; }
	if (level >= board.length * board[row].length) return true;

	boolean s = false;
	for (int i = 0; i < 8; i += 8) {
	    if (solveH(row + dRow[i], col + dCol[i], level + 1)) s = true;
	}
	if (s) return true;
	
	/*
	int i = 0;
	if (solveH(row + dRow[i + 0], col + dCol[i + 0], level + 1) ||
	    solveH(row + dRow[i + 1], col + dCol[i + 1], level + 1) ||
	    solveH(row + dRow[i + 2], col + dCol[i + 2], level + 1) ||
	    solveH(row + dRow[i + 3], col + dCol[i + 3], level + 1) ||
	    solveH(row + dRow[i + 4], col + dCol[i + 4], level + 1) ||
	    solveH(row + dRow[i + 5], col + dCol[i + 5], level + 1) ||
	    solveH(row + dRow[i + 6], col + dCol[i + 6], level + 1) ||
	    solveH(row + dRow[i + 7], col + dCol[i + 7], level+ 1))
	    return true;
	*/

	for (int r = 0; r < board.length; r += 1) {
	    for (int c = 0; c < board[r].length; c += 1) {
		if (board[r][c] == level) board[r][c] = 0;	    
	    }
	}
	return false;
    }

    public void clearGreater(int level){
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[0].length;col++){
		if(board[row][col] == level){
		    board[row][col] = 0;
		}
	    }
	}
    }

    public static void main(String[] args) {
	KnightBoard a = new KnightBoard(5,7);
	//System.out.println(a.solveH(3,3,1));
	a.solve();
	System.out.println(a);
    }
    
}
