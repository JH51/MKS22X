import java.util.*;
import java.io.*;

public class Maze {

    private char[][] maze;
    private boolean animate;

    public Maze(String filename) {
	setAnimate(true);
	File text = new File(filename);
	try {
        Scanner inf1 = new Scanner(text);
        int cols = 0, rows = 1;
        while (inf1.hasNextLine()) {
            String line = inf1.nextLine();
	    rows += 1;
	    cols = line.length();
        }
	maze = new char[rows][cols];
	Scanner inf2 = new Scanner(text);
	int col, row = 0;
	while (inf2.hasNextLine()) {
	    String line = inf2.nextLine();
	    col = 0;
	    while (line.length() > 0) {
		maze[row][col] = line.charAt(0);
		//System.out.println(maze[row][col] + " " + row + " " + col);
		line = line.substring(1);
		col += 1;
	    }
	    row += 1;
	} }
	catch (FileNotFoundException e) {
	    maze = new char[0][0];
	}
    }

    /*
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
    */
    
    private void wait(int millis) {
	try { Thread.sleep(millis); }
	catch (InterruptedException e) { }
    }
    
    public void setAnimate(boolean b) {
        animate = b;
    }
    
    public boolean solve() {
	int startX = 1, startY = 1;
	maze[startX][startY] = ' ';
	return solve(startX, startY);
    }
    
    private boolean solve(int x, int y) {
        if (animate) {
            System.out.println("\033[2J\033[1;1H"+this);	    
	    wait(20);
        }
	if (maze[y][x] == 'E') return true;
	if (maze[y][x] == ' ') {
	    if (maze[y - 1][x] == ' ') {
		if (solve(x - 1, y) ||
		    solve(x + 1, y) ||
		    solve(x, y - 1) ||
		    solve(x, y + 1)) maze[y][x] = '@';
	    }
	}
	return false;
    }

    public String toString() {
	String finalStr = "";
	for (int row = 0; row < maze.length; row += 1) {
	    for (char col = 0; col < maze[row].length; col += 1) {
		finalStr += maze[row][col];
	    }
	    finalStr += "\n";
	}
	return finalStr;
    }
    
    public static void main(String[] args) {
	Maze a = new Maze("data3.dat");
	System.out.println(a.solve());
    }
}
