import java.util.*;
import java.io.*;

public class Maze {

    private char[][] maze;
    private boolean animate;

    public Maze(String filename, boolean ani) {
	setAnimate(ani);
	File file  = new File(filename);
	Scanner scanner = new Scanner(file);
	int lineNumber = 1;
	int x = 0, y = 0;
	while (inf.hasNextLine()) {
	    String line = inf.nextLine();
	    while (line.length() > 0) {
		maze[y][x] = line.charAt(0);
		line = line.substring(1);
	    }
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
	if (maze[y - 1][x] == ' ') {
	    if (solve(x, y - 1)) maze[y - 1][x] = '@';
	}
	if (maze[y + 1][x] == ' ') {
	    if (solve(x, y + 1)) maze[y + 1][x] = '@';
	}
	if (maze[y][x - 1] == ' ') {
	    if (solve(x - 1, y)) maze[y][x - 1] = '@';
	}
	if (maze[y][x + 1] == ' ') {
	    if (solve(x + 1, y)) maze[y][x + 1] = '@';
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
	return finalStr;
    }
    
}
