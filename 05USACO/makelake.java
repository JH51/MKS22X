import java.io.*;
import java.util.*;

public class makelake {
    
    int[][] lake;

    public makelake(String filename) {
	File file = new File(filename);
	try {
	    Scanner scanner = new Scanner(file);
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
