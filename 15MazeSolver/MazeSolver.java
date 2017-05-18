public class MazeSolver {
    
    private Maze board;
    
    public MazeSolver(String s) {
	board = new Maze(s);
    }
    
    public void solve() {
	solve(0);
	return;
    }
    
    public void solve(int i) {
	for (int row = 0; row < board.maxRows; row += 1) {
	    for (int col = 0; row < board.maxCols; col += 1) {
		if (board.get(row, col) == 'S') {
		    int r = row;
		    int c = col;
		}
	    }
	}
	switch (i) {
	case 0:
	    DepthFirst(r, c);
	    break;
	}
	return;
    }

    public boolean DepthFirst(int r, int c) {
	if (board.get(r, c) == 'E') return true;
	if (board.get(r, c) == ' ') {
	    board.set(r, c, '@');
	    boolean b =
		DepthFirst(r - 1, c) ||
		DepthFirst(r + 1, c) ||
		DepthFirst(r, c - 1) ||
		DepthFirst(r, c + 1);
	    if (b) return true;
	    else board.set(r, c, '.');
	}
	return false;
    }

}
