import java.io.*;
import java.util.*;

public class makelake {
    
    int[][] lake;
    int[][] directions;
    int R, C, E, N;

    public makelake(String filename) {
	File file = new File(filename);
	try {
	    Scanner scanner = new Scanner(file);
	    String[] temp = new String[] {"", "", "", ""};
	    int i = 0;
	    R = Integer.parseInt(scanner.next());
	    C = Integer.parseInt(scanner.next());
	    E = Integer.parseInt(scanner.next());
	    N = Integer.parseInt(scanner.next());
	    lake = new int[R][C];
	    for (int row = 0; row < lake.length && scanner.hasNextLine(); row += 1) {
		for (int col = 0; col < lake[row].length; col += 1) {
		    if (scanner.hasNext()) lake[row][col] = Integer.parseInt(scanner.next());
		}
	    }
	}
	catch (FileNotFoundException e) {
	    lake = new int[3][3];
	}
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
		if (lake[row][col] < 10) string += " ";
		string += lake[row][col] + " ";
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
