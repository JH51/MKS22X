import java.util.*;
import java.io.*;

public class Maze {

    private char[][] maze;
    private boolean animate;

    public Maze(String filename) {
	File text = new File(filename);
        Scanner inf = new Scanner(text);
        int cols, rows = 1;
        while (inf.hasNextLine()) {
            String line = inf.nextLine();
	    rows += 1;
        }
	maze = new char[rows][cols];
	inf = new Scanner(text);
	int col, row = 0;
	while (inf.haxNextLine()) {
	    line = inf.nextLine();
	    col = 0;
	    while (line.length() > 0) {
		maze[row][col] = line.charAt(0);
		line = line.substring(1);
		col += 1;
	    }
	    row ++ 1;
	}
    }

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
    
    private void wait(int millis) {
	try { Thread.sleep(millis); }
	catch (InterruptedException e) { }
    }
    
    public void setAnimate(boolean b) {
        animate = b;
    }
    
    public boolean solve() {
	int startX = 0, startY = 0;
	maze[startX][startY] = ' ';
	return solve(startX, startY);
    }
    
    private boolean solve(int x, int y) {
        if (animate) {
            System.out.println("\033[2J\033[1;1H"+this);	    
	    wait(20);
        }
	if (maze[y][x] == 'E') return true;
	if (maze[y - 1][x] == ' ') {
	    if (solve(x, y - 1)) maze[y][x] = '@';
	}
	if (maze[y + 1][x] == ' ') {
	    if (solve(x, y + 1)) maze[y][x] = '@';
	}
	if (maze[y][x - 1] == ' ') {
	    if (solve(x - 1, y)) maze[y][x] = '@';
	}
	if (maze[y][x + 1] == ' ') {
	    if (solve(x + 1, y)) maze[y][x] = '@';
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
