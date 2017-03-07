import java.io.*;
import java.util.*;

public class makelake {
    
    int[][] lake;

    public makelake(String filename) {
	File file = new File(filename);
	try {
	    Scanner scanner = new Scanner(file);
	    int R, C, E, N;
	    String[] temp = new String[4];
	    int i = 0;
	    String line = scanner.nextLine();
	    while (line.length() > 0 && i < 4) {
		while (! line.substring(0, 1).equals(" ")) {
		    temp[i] += line.substring(0, 1);
		    line = line.substring(1);
		}
		i += 1;
		line = line.substring(1);
	    }
	    R = Integer.parseInt(temp[0]);
	    C = Integer.parseInt(temp[1]);
	    E = Integer.parseInt(temp[2]);
	    N = Integer.parseInt(temp[3]);
	    while (scanner.hasNextLine()) {
		
	    }
	    lake = new int[R][C];
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
