import java.io.*;
import java.util.*;

public class Silver {
    
    char[][] pasture;
    int N, M, T, R1, C1, R2, C2, S;
    
    public Silver(String filename) {
	File file = new File(filename);
	try {
	    Scanner scanner = new Scanner(file);
	    //System.out.println(scanner.nextLine());
	    N = Integer.parseInt(scanner.next());
	    M = Integer.parseInt(scanner.next());
	    T = Integer.parseInt(scanner.next());
	    System.out.println(N + " " + M + "  " + T);
	    pasture = new char[N][M];

	    scanner.nextLine();
	    for (int row = 0; row < N; row += 1) {
		String line = scanner.nextLine();
		for (int col = 0; col < M; col += 1) {
		    pasture[row][col] = line.charAt(col);
		    System.out.println("START\n" + this);
		}
	    }
	    
	    //scanner.nextLine();
	    R1 = Integer.parseInt(scanner.next());
	    C1 = Integer.parseInt(scanner.next());
	    R2 = Integer.parseInt(scanner.next());
	    C2 = Integer.parseInt(scanner.next());
	    System.out.println(R1 + " " + C1 + " " + R2 + " " + C2);
	}
	catch (FileNotFoundException e) { }
    }
    
    public String toString() {
	String string = "";
	for (int row = 0; row < pasture.length; row += 1) {
	    for (int col = 0; col < pasture[row].length; col += 1) {
		string += pasture[row][col];
	    }
	    string += "\n";
	}
	return string;
    }

    public static void main(String[] args) {
	Silver a = new Silver("ctravel.in");
	System.out.println(a);
    }

}
