public class Maze {

    private char[][] maze;
    private boolean animate;

    public Maze(String filename, boolean ani) {
    }
    
    public void setAnimate(boolean b) {
        animate = b;
    }
    
    public boolean solve() {
	int startx=0,starty=0;
	maze[startx][starty] = ' ';
	return solve(startx,starty);
    }
    
    private boolean solve(int x, int y) {
        if (animate) {
            System.out.println(this);
            wait(20);
        }
	return false;
    }
    
}
