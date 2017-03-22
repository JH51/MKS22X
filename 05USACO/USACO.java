import java.util.*;
import java.io.*;

public class USACO {

    public USACO() {
    }
    
    public int bronze(String filename) {
	Bronze lake = new Bronze(filename);
	return lake.V;
    }
    
    public int silver(String filename) {
	Silver ctravel = new Silver(filename);
	return ctravel.S;
    }

    public static void main(String[] args) {
	USACO x = new USACO();
	System.out.println(x.bronze("Test Files/Bronze/makelake.10.in"));	
	System.out.println(x.silver("Test FIles/Silver/ctravel.2.in"));
    }
	
}
