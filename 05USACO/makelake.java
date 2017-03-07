import java.io.*;
import java.util.*;

public class makelake {
    
    int[][] lake;

    public makelake(String filename) {
	File file = new File(filename);
	try {
	    Scanner scanner = new Scanner(file);
	    int R, C, E, N;
	    int[] RCEN = new int[4];
	    int i = 0;
	    String temp = "", line = scanner.nextLine();
	    while (line.length() > 0 && i < 4) {
		while (! line.substring(0, 1).equals(" ")) {
		    temp += line.substring(0, 1);
		    line = line.substring(1);
		}
		int[i] = Integer.parseInt(temp);
		int += 1 ;
		temp = "";
	    }
	    R = RCEN[0];
	    C = RCEN[1];
	    E = RCEN[2];
	    N = RCEN[3];	   
	    while (scanner.hasNextLine()) {
		
	    }
	}
	catch (FileNotFoundException e) {
	    lake = new int[3][3];
	}
    }
    
    public void stomp(int R_s, int C_s, int D_s) {
	
    }
    
    public static void main(String args[]) {
	System.out.println(Integer.parseInt("4 6 22 2"));
    }
    
}
