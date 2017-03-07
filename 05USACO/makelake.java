import java.io.*;
import java.util.*;

public class makelake {
    
    int[][] lake;
    int[][] directions;

    public makelake(String filename) {
	File file = new File(filename);
	try {
	    Scanner scanner = new Scanner(file);
	    int R, C, E, N;
	    String[] temp = new String[] {"", "", "", ""};
	    int i = 0;
	    String line = scanner.nextLine();
	    for (int j = 0; j < line.length(); j += 1) {	
		if (line.charAt(j) != ' ') temp[i] += line.charAt(j);
		else i += 1;
	    }	    
	    R = Integer.parseInt(temp[0]);
	    C = Integer.parseInt(temp[1]);
	    E = Integer.parseInt(temp[2]);
	    N = Integer.parseInt(temp[3]);
	    lake = new int[R][C];
	    for (int row = 0; row < lake.length && scanner.hasNextLine(); row += 1) {
		line = scanner.nextLine();
		System.out.println("LINE " + line);
		i = 0;
		for (int col = 0; col < lake[row].length; col += 1) {
		    System.out.println(line.charAt(i));
		    while (line.charAt(i) != ' ' && i < line.length() - 1) {
			lake[row][col] *= 10;
			lake[row][col] += (int) line.charAt(0);
			i += 1;
		    }
		    i += 1;
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
	//	System.out.println(temp);
	for (int r = R_s; r < R_s + 3; r += 1) {
	    for (int c = C_s; c < C_s + 3; c += 1) {
		//System.out.println(temp + " : " + i);
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
	//	System.out.print(a);
	a.stomp(1, 1, 100);
	a.stomp(1, 2, 200);
	System.out.println(a);
    }
    
}
