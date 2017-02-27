import java.util.*;
import java.io.*;

public class Maze {

    private char[][] maze;
    private boolean animate;

    public Maze(String filename, boolean ani) {
	setAnimate(ani);
	File infile = new File(filename);
	Scanner inf = new Scanner(text);
	int lineNumber = 1;
	while (inf.hasNextLine()) {
	    String line = inf.nextLine();
	}
    }
    
    public void setAnimate(boolean b) {
        animate = b;
    }
    
    public boolean solve() {
	int startX = 0, startY = 0;
	maze[startX][starty] = ' ';
	return solve(startX, startY);
    }
    
    private boolean solve(int x, int y) {
        if (animate) {
            System.out.println(this);
            wait(20);
        }
	if (maze[y][x] == 'E') return true;
	if (maze[y - 1][x] != '#') {
	    return solve(x, y - 1);
	}
	if (maze[y + 1][x] != 'x') {
	    return solve(x, y + 1);
	}
	if (maze[y][x - 1] != '#') {
	    return solve(x - 1, y);
	}
	if (maze[y][x + 1] != '#') {
	    return solve(x + 1, y);
	}
	return false;
    }

    public String toString() {
	String finalStr = "";
	for (char[] c1 : maze[]) {
	    for (char c2 : maze[0]) {
		finalStr += c2;
	    }
	}
    }
    
}
