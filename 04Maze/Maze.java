import java.util.*;
import java.io.*;

public class Maze {

    private char[][] maze;
    private boolean animate;

    public Maze(String filename, boolean ani) {
	setAnimate(ani);
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
