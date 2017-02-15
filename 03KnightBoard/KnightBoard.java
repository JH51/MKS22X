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
	System.out.println(solveH(3, 3, 1));
    }
    
    private boolean solveH(int row, int col, int level) {
	System.out.println(level + " " + board.length * board[row].length + "\n" + this);
	boolean OoB = false; 
	if (level == board.length * board[row].length) return true;;
	try {
	    if (solveH(row - 2, col - 1, level + 1)) {
		if (board[row][col] == 0) {
		    board[row - 2][col - 1] = level;
		    return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {OoB = true;}
	try {
	    if (solveH(row - 2, col + 1, level + 1)) {
		if (board[row][col] == 0) {
		    board[row - 2][col + 1] = level;
		    return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {OoB = true;}
	try {
	    if (solveH(row + 2, col - 1, level + 1)) {
		if (board[row][col] == 0) {
		    board[row + 2][col - 1] = level;
		    return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {OoB = true;}
	try {
	    if (solveH(row + 2, col + 1, level + 1)) {
		if (board[row][col] == 0) {
		    board[row + 2][col + 1] = level;
		    return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {OoB = true;}
	try {
	    if (solveH(row - 1, col - 2, level + 1)) {
		if (board[row][col] == 0) {
		    board[row - 1][col - 2] = level;
		    return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {OoB = true;}
	try {
	    if (solveH(row + 1, col - 2, level + 1)) {
		if (board[row][col] == 0) {
		    board[row + 1][col - 2] = level;
		    return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {OoB = true;}
	try {
	    if (solveH(row - 1, col + 2, level + 1)) {
		if (board[row][col] == 0) {
		    board[row - 1][col + 2] = level;
		    return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {OoB = true;}
	try {
	    if (solveH(row + 1, col + 2, level + 1)) {
		if (board[row][col] == 0) {
		    board[row + 1][col + 2] = level;
		    return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {OoB = true;}
	return ! OoB;
	//return false;
    }

    /*
    private boolean solveH(int row, int col, int level) {
	System.out.println(level + " " + board.length * board[row].length + "\n" + this);
	boolean OoB = false; 
	if (level == board.length * board[row].length) return true;;
	try {
	    if (solveH(row - 2, col - 1, level + 1)) {
		board[row - 2][col - 1] = level;
		return true;
	    }
	}
	catch (IndexOutOfBoundsException e) {
	    OoB = true;	    
	}
	try {
	    if (solveH(row - 2, col + 1, level + 1)) {
		if (board[row][col] == 0) {
		board[row - 2][col + 1] = level;
	    	return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {
	    OoB = true;
	}
	try {
	    if (solveH(row + 2, col - 1, level + 1)) {
		if (board[row][col] == 0) {
		board[row + 2][col - 1] = level;
	    	return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {
	    OoB = true;
	}
	try {
	    if (solveH(row + 2, col + 1, level + 1)) {
		if (board[row][col] == 0) {
		board[row + 2][col + 1] = level;
		return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {
	    OoB = true;
	}
	try {
	    if (solveH(row - 1, col - 2, level + 1)) {
		if (board[row][col] == 0) {
		board[row - 1][col - 2] = level;
	    	return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {
	    OoB = true;
	}
	try {
	    if (solveH(row + 1, col - 2, level + 1)) {
		if (board[row][col] == 0) {
		board[row + 1][col - 2] = level;
	    	return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {
	    OoB = true;
	}
	try {
	    if (solveH(row - 1, col + 2, level + 1)) {
		if (board[row][col] == 0) {
		board[row - 1][col + 2] = level;
	    	return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {
	    OoB = true;
	}
	try {
	    if (solveH(row + 1, col + 2, level + 1)) {
		if (board[row][col] == 0) {
		board[row + 1][col + 2] = level;
		return true;}
	    }
	}
	catch (IndexOutOfBoundsException e) {
	    OoB = true;;
	}
	if (OoB) return false;
	return false;
    }
    */
    
    public static void main(String[] args) {
	KnightBoard a = new KnightBoard(7, 7);
	//System.out.println(a.solveH(3,3,1));
	a.solve();
	System.out.println(a);
    }
    
}
