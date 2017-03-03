import java.util.*;
import java.io.*;

public class Maze {

    private char[][] maze;
    private boolean animate;
    private String color01 = "\u001B[0m", color02 = "\u001b[32m";
    
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
		    line = line.substring(1);
		    col += 1;
		}
		row += 1;
	    }
	}
	catch (FileNotFoundException e) {
	    maze = new char[1][1];
	}
    }

    public Maze(String filename, boolean animate) {
	setAnimate(animate);
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
		    line = line.substring(1);
		    col += 1;
		}
		row += 1;
	    }
	}
	catch (FileNotFoundException e) {
	    maze = new char[1][1];
	}
    }
    
    private void wait(int millis) {
	try { Thread.sleep(millis); }
	catch (InterruptedException e) { }
    }
    
    public void setAnimate(boolean b) {
        animate = b;
    }

    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }
    
    public boolean solve() {
	for (int row = 0; row < maze.length; row += 1) {
	    for (int col = 0; col < maze[row].length; col += 1) {
		if (maze[row][col] == 'S') {
		    maze[row][col] = ' ';
		    return solve(row, col);
		}
	    }
	}
	return false;
    }
    
    private boolean solve(int x, int y) {
        if (animate) {
            System.out.println("\033[2J\033[1;1H"+this);//.toString(true));
	    wait(20);
        }
	if (maze[x][y] == 'E') return true;
	if (maze[x][y] == ' ') {
	    maze[x][y] = '@';
	    boolean b =
		solve(x - 1, y) ||
		solve(x + 1, y) ||
		solve(x, y - 1) ||
		solve(x, y + 1);
	    if (b) return true;
	    else maze[x][y] = ' ';
	}
	return false;
    }
    //"\u001b[32m"

    public String toString() {
	String finalStr = "";
	for (int row = 0; row < maze.length; row += 1) {
	    for (char col = 0; col < maze[row].length; col += 1) {
		finalStr += maze[row][col] + " ";
	    }
	    finalStr += "\n";
	}
	return finalStr;
    }

    public String toString(boolean b) {
	String finalStr1 = toString(), finalStr2 = toString();
	if (b) {
	    finalStr2 = "";
	    while (finalStr1.length() > 0) {
		if (finalStr1.charAt(0) == '#') finalStr2 += color02;
		finalStr2 += finalStr1.charAt(0) + color01;
		finalStr1 = finalStr1.substring(1);
	    }
	}
	return finalStr2;
    }
    
    public static void main(String[] args) {
	Maze a = new Maze("data3.dat");//, false);
	//a.solve();
	System.out.println(a.solve());
    }
}
