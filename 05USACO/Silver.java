import java.io.*;
import java.util.*;

public class Silver {

    char[][] pasture;
    int[][][] pasture2;
    int N, M, T, R1, C1, R2, C2, S;

    public Silver(String filename) {
	File file = new File(filename);
	try {
	    Scanner scanner = new Scanner(file);
	    N = Integer.parseInt(scanner.next());
	    M = Integer.parseInt(scanner.next());
	    T = Integer.parseInt(scanner.next());
	    pasture = new char[N][M];
	    pasture2 = new int[2][N][M];

	    scanner.nextLine();
	    for (int row = 0; row < N; row += 1) {
		String line = scanner.nextLine();
		for (int col = 0; col < M; col += 1) {
		    pasture[row][col] = line.charAt(col);
		    if (pasture[row][col] == '.') pasture2[0][row][col] = 0;
		    else pasture2[0][row][col] = -1;
		}
	    }

	    R1 = Integer.parseInt(scanner.next());
	    C1 = Integer.parseInt(scanner.next());
	    R2 = Integer.parseInt(scanner.next());
	    C2 = Integer.parseInt(scanner.next());

	    S = travel2();
	    //travel(R1 - 1, C1 - 1, R2 - 1, C2 - 1, T);
	}

	catch (FileNotFoundException e) { }

	while (filename.indexOf(".") != -1 && filename.charAt(filename.length() - 1) != '.') {
	    filename = filename.substring(0, filename.length() - 1);
	}
	try {
	    PrintWriter fileOut = new PrintWriter(filename + "out", "UTF-8");
	    fileOut.println(S);
	    fileOut.close();
	}
	catch (IOException e) { }
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

    public String toString(int i) {
	String string = "";
	for (int row = 0; row < pasture.length; row += 1) {
	    for (int col = 0; col < pasture[row].length; col += 1) {
		string += pasture2[i][row][col] + " ";
	    }
	    string += "\n";
	}
	return string;
    }

    public void travel(int R1, int C1, int R2, int C2, int T) {
	if (T == 0 && R1 == R2 && C1 == C2) {
	    S += 1;
	    return;
	}
	if (T <= 0 ||
	    R1 < 0 ||
	    R1 >= pasture.length ||
	    C1 < 0 ||
	    C1 >= pasture[0].length) return;
	if (pasture[R1][C1] != '*') {
	    travel(R1 - 1, C1, R2, C2, T - 1);
	    travel(R1 + 1, C1, R2, C2, T - 1);
	    travel(R1, C1 - 1, R2, C2, T - 1);
	    travel(R1, C1 + 1, R2, C2, T - 1);
	}
	return;
    }

    public int travel2() {
	R1 -= 1;
	C1 -= 1;
	R2 -= 1;
	C2 -= 1;

	try { if (pasture2[0][R1 - 1][C1] != -1) pasture2[0][R1 - 1][C1] = 1; }
	catch (IndexOutOfBoundsException e) { };
	try { if (pasture2[0][R1 + 1][C1] != -1) pasture2[0][R1 + 1][C1] = 1; }
	catch (IndexOutOfBoundsException e) { };
	try { if (pasture2[0][R1][C1 - 1] != -1) pasture2[0][R1][C1 - 1] = 1; }
	catch (IndexOutOfBoundsException e) { };
	try { if (pasture2[0][R1][C1 + 1] != -1) pasture2[0][R1][C1 + 1] = 1; }
	catch (IndexOutOfBoundsException e) { };
	//System.out.println(this.toString(0));

	int time = 1;
	while (time < T) {
	    pasture2[1] = new int[N][M];
	    for (int row = 0; row < pasture2[0].length; row += 1) {
		for (int col = 0; col < pasture2[0][0].length; col += 1) {
		    if (pasture2[0][row][col] != -1) {
			try { if (pasture2[0][row - 1][col] != -1) pasture2[1][row][col] += pasture2[0][row - 1][col]; }
			catch (IndexOutOfBoundsException e) { };
			try { if (pasture2[0][row + 1][col] != -1) pasture2[1][row][col] += pasture2[0][row + 1][col]; }
			catch (IndexOutOfBoundsException e) { };
			try { if (pasture2[0][row][col - 1] != -1) pasture2[1][row][col] += pasture2[0][row][col - 1]; }
			catch (IndexOutOfBoundsException e) { };
			try { if (pasture2[0][row][col + 1] != -1) pasture2[1][row][col] += pasture2[0][row][col + 1]; }
			catch (IndexOutOfBoundsException e) { };
		    }
		    else pasture2[1][row][col] = -1;
		}
	    }
	    pasture2[0] = pasture2[1];
	    //System.out.println(time + " " + T + "\n" + this.toString(0));
	    time += 1;
	}
	return pasture2[0][R2][C2];
    }

    public static void main(String[] args) {
	Silver a = new Silver("Test Files/Silver/ctravel.10.in");
	//System.out.println(a.toString2());
    }

}
