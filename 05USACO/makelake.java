import java.io.*;
import java.util.*;

public class makelake {
    
    int[][] lake;
    int[][] directions;
    int R, C, E, N, V;

    public makelake(String filename) {
	File file = new File(filename);
	try {
	    Scanner scanner = new Scanner(file);
	    R = Integer.parseInt(scanner.next());
	    C = Integer.parseInt(scanner.next());
	    E = Integer.parseInt(scanner.next());
	    N = Integer.parseInt(scanner.next());
	    lake = new int[R][C];
	    for (int r = 0; r < R && scanner.hasNextLine(); r += 1) {
		for (int c = 0; c < C && scanner.hasNext(); c += 1) {
		    lake[r][c] = Integer.parseInt(scanner.next());
		}
	    }
	    directions = new int[N][3];
	    for (int i = 0; i < N; i += 1) {
		for (int j = 0; j < 3; j += 1) {
		    directions[i][j] = Integer.parseInt(scanner.next());
		}
	    }

	    for (int i = 0; i < directions.length; i += 1) {
		System.out.println(this + "\n");
		stomp(directions[i][0], directions[i][1], directions[i][2]);
	    }

	    for (int r = 0; r < lake.length; r += 1) {
		for (int c = 0; c < lake[r].length; c += 1) {
		    if (lake[r][c] >= E) lake[r][c] = 0;
		    else lake[r][c] = E - lake[r][c];
		}
	    }
	}
	catch (FileNotFoundException e) { }
    }
    
    public void stomp(int R_s, int C_s, int D_s) {
	R_s -= 1;
	C_s -= 1;
	int max = lake[R_s][C_s];
	for (int r = R_s; r < R_s + 3; r += 1) {
	    for (int c = C_s; c < C_s + 3; c += 1) {
		if (lake[r][c] >= max) max = lake[r][c];
	    }
	}
	int temp = max - D_s;
	for (int r = R_s; r < R_s + 3; r += 1) {
	    for (int c = C_s; c < C_s + 3; c += 1) {
		if (lake[r][c] > temp) lake[r][c] = temp;
	    }
	}
    }

    public String toString() {
	String string = "";
	for (int row = 0; row < lake.length; row += 1) {
	    for (int col = 0; col < lake[row].length; col += 1) {
		if (lake[row][col] == 0) string += "-- ";
		else {
		    if (lake[row][col] < 10) string += " ";
		    string += lake[row][col] + " ";		    
		}
	    }
	    string += "\n";
	}
	return string;
    }
    
    public static void main(String args[]) {
	makelake a = new makelake("makelake.in");
	//	a.stomp(1, 1, 100);
	//	a.stomp(1, 2, 200);
	System.out.println(a);
    }
    
}
