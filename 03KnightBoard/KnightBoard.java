public class KnightBoard {
    
    private int[][] board;
    
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
    }
    
    private boolean solveH(int row ,int col, int level) {// level is the # of the knight
	return true;
    }

    public static void main(String[] args) {
	KnightBoard a = new KnightBoard(7, 6);
	System.out.println(a);
    }
    
}
